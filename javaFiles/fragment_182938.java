@SupportedAnnotationTypes("your.package.PatternMatches")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MyCustomAnnotationProcessor extends AbstractProcessor {
    private ProcessingEnvironment processingEnv;
    @Override
    public synchronized void init(ProcessingEnvironment env){
        processingEnv = env;
    }
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(PatternMatches.class);
        Set<VariableElement> params = ElementFilter.fieldsIn(elements);
        for (VariableElement param : params) {
            String val = param.getConstantValue();
            String regex = param.getAnnotation(PatternMatches.class).value();
            if (!val.matches(regex)) {
                processingEnv.getMessager().printMessage(
Diagnostic.Kind.ERROR, "Regex match failed", param);
            }
        }
        return false;
    }
}