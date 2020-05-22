@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("org.printMethod.PrintMethod")
public class PrintMethodAnnotationProcessor extends AbstractProcessor {

    private Trees trees;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        trees = Trees.instance(processingEnv); //initialize the Trees api.
    }

    @Override
    public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment roundEnvironment) {

        MethodPrintScanner visitor = new MethodPrintScanner();

        for (Element e : roundEnvironment.getElementsAnnotatedWith(PrintMethod.class)) {
            TreePath tp = trees.getPath(e);
            // visit the annotated methods
            visitor.scan(tp, trees);
        }
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}