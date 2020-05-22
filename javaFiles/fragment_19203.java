import java.io.InputStream;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.List;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.util.*;

public class ClassReaderTest1 {

    public static void main(String[] args) throws Exception{
        InputStream in = new FileInputStream("*afile*");
        ClassReader reader = new ClassReader(in);
        ClassNode classNode = new ClassNode();
        reader.accept(classNode,0);
        @SuppressWarnings("unchecked")
        final List<MethodNode> methods = classNode.methods;
        for(MethodNode m: methods){
             InsnList inList = m.instructions;
             System.out.println(m.name);
             for(int i = 0; i< inList.size(); i++){
                 System.out.print(insnToString(inList.get(i)));
             }
        }
    }

    public static String insnToString(AbstractInsnNode insn){
        insn.accept(mp);
        StringWriter sw = new StringWriter();
        printer.print(new PrintWriter(sw));
        printer.getText().clear();
        return sw.toString();
    }

    private static Printer printer = new Textifier();
    private static TraceMethodVisitor mp = new TraceMethodVisitor(printer); 

}