import java.io.IOException;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.LineMap;
import com.sun.source.tree.MethodTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TreeScanner;
import com.sun.source.util.Trees;

public class MethodFinder {

    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
        Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects("path/to/Source.java");
        CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, fileObjects);

        // Here we switch to Sun-specific APIs
        JavacTask javacTask = (JavacTask) task;
        SourcePositions sourcePositions = Trees.instance(javacTask).getSourcePositions();
        Iterable<? extends CompilationUnitTree> parseResult = null;
        try {
            parseResult = javacTask.parse();
        } catch (IOException e) {

            // Parsing failed
            e.printStackTrace();
            System.exit(0);
        }
        for (CompilationUnitTree compilationUnitTree : parseResult) {
            compilationUnitTree.accept(new MethodLineLogger(compilationUnitTree, sourcePositions), null);
        }
    }

    private static class MethodLineLogger extends TreeScanner<Void, Void> {
        private final CompilationUnitTree compilationUnitTree;
        private final SourcePositions sourcePositions;
        private final LineMap lineMap;

        private MethodLineLogger(CompilationUnitTree compilationUnitTree, SourcePositions sourcePositions) {
            this.compilationUnitTree = compilationUnitTree;
            this.sourcePositions = sourcePositions;
            this.lineMap = compilationUnitTree.getLineMap();
        }

        @Override
        public Void visitMethod(MethodTree arg0, Void arg1) {
            long startPosition = sourcePositions.getStartPosition(compilationUnitTree, arg0);
            long startLine = lineMap.getLineNumber(startPosition);
            long endPosition = sourcePositions.getEndPosition(compilationUnitTree, arg0);
            long endLine = lineMap.getLineNumber(endPosition);

            // Voila!
            System.out.println("Found method " + arg0.getName() + " from line " + startLine + " to line "  + endLine + ".");

            return super.visitMethod(arg0, arg1);
        }
    }
}