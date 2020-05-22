import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.objectweb.asm.*;

public class EnumHack {
    interface Foo {
        public void bar();
    }
    enum MyEnum {
        A {
            public void bar() {
                System.out.println("Hello!");
            }
        },
        B,
        C;
    }
    public static void main(String... arg) {
        try {
            patch();
        } catch (IOException|URISyntaxException ex) {
            System.err.println("patching failed: "+ex);
            return;
        }
        test();
    }
    static void test() {
        for(MyEnum e: MyEnum.values()) {
            System.out.println(e.name());
            if (e instanceof Foo) {
                System.out.println("\timplements Foo");
                ((Foo)e).bar();
            }
        }
    }
    static void patch() throws IOException, URISyntaxException {
        URL url = MyEnum.class.getResource("EnumHack$MyEnum$1.class");
        ClassReader cr=new ClassReader(url.openStream());
        ClassWriter cw=new ClassWriter(cr, 0);
        cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
            @Override
            public void visit(int version, int access, String name,
                    String signature, String superName, String[] interfaces) {
                if(interfaces.length==0) // not patched yet
                    interfaces=new String[] { Foo.class.getName() };
                super.visit(version, access, name, signature, superName, interfaces);
            }
        }, 0);
        Files.write(Paths.get(url.toURI()), cw.toByteArray());
    }
}