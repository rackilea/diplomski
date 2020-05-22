import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.FieldDeclaration;

public class JavaFPMain {

    public static void main(String[] args) throws Exception {
        JavaFPMain fpApp = new JavaFPMain();
        fpApp.run();
    }

    private void run() throws Exception {
        File projectDir = new File(...);
        FileUtils.listFiles(projectDir, new RegexFileFilter(".*.java"), DirectoryFileFilter.DIRECTORY)
            .stream()
            .forEach(this::parseFile);

        System.out.println("done");
    }

    private void parseFile(final File fi) {
        try {
            CompilationUnit compilationUnit = JavaParser.parse(fi);

            String AUTOWIRED = "Autowired";
            compilationUnit.getNodesByType(FieldDeclaration.class).stream()
                .filter(f -> !f.getModifiers().contains(Modifier.FINAL) &&
                             !containsAnnotation(f, AUTOWIRED))
                .forEach(f -> System.out.println("missing final: " + fi.getAbsolutePath() + "(" + f.getBegin().get().line + ") " + f.getVariable(0).getNameAsString()));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private boolean containsAnnotation(FieldDeclaration f, String name) {
        return f.getAnnotations()
                .stream()
                .anyMatch(a -> a.getNameAsString().equals(name));
    }

}