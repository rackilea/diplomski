import com.github.javaparser.ast.CompilationUnit;

public class RemoveComments {
    public static void main(String[] args) {
        JavaParser.getStaticConfiguration().setAttributeComments(false);
        CompilationUnit cu = JavaParser.parse("/**a*/package a.b.c; //\nclass X{}");
        System.out.println(cu);
    }
}