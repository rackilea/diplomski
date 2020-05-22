import java.io.InputStream;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;

public class App{
    public static void main( String[] args ) {
        try {
            Test test = new Test();

                test.findCallers();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


class Test {
    private String targetClass;
    private Method targetMethod;

    private AppClassVisitor cv;

    class AppMethodVisitor extends MethodVisitor {
        boolean callsTarget;
        int line;

        public AppMethodVisitor() { 
            super(Opcodes.ASM5); 
        }

        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            if (owner.equals("Fibonacci") && name.equals("join") && desc.equals("()V")) {
                callsTarget = true;
                System.out.println("Function join called on " + this.line);
            }
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }

        public void visitCode() {
            callsTarget = false;
        }

        public void visitLineNumber(int line, Label start) {
            this.line = line;
        }

        public void visitEnd() {
            if (callsTarget){
                System.out.println(cv.className + cv.methodName + cv.methodDesc  + line);
            }
        }
    }

    class AppClassVisitor extends ClassVisitor {
        private AppMethodVisitor mv = new AppMethodVisitor();

        public String className;
        public String methodName;
        public String methodDesc;

        public AppClassVisitor() { 
            super(Opcodes.ASM5); 
        }

        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            className = name;
        }

        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            methodName = name;
            methodDesc = desc;

            return mv;
        }
    }

    public void findCallers() throws Exception {
        InputStream stream = App.class.getResourceAsStream("Fibonacci.class");
        ClassReader reader = new ClassReader(stream);
        cv = new AppClassVisitor();

        reader.accept(cv, 0);

        stream.close();
    }
}