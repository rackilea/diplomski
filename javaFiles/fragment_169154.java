import JVM1.jvmBasicLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Jvm extends jvmBasicBaseVisitor<Object> {


    public static void main(String[] args) {
        jvmBasicLexer lexer = new jvmBasicLexer(new ANTLRInputStream("10 PRINT \"Hello!\""));
        jvmBasicParser parser = new jvmBasicParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.prog();
    }

}