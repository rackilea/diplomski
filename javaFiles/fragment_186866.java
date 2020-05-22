@SupportedAnnotationTypes("*")   // needed to run on all classes being compiled
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class DefaultConstructor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {

        for (TypeElement type : ElementFilter.typesIn(roundEnv.getRootElements())) {
            if (requiresDefaultConstructor(type))
                checkForDefaultConstructor(type);
        }
        return false;
    }

    private void checkForDefaultConstructor(TypeElement type) {
        for (ExecutableElement cons :
            ElementFilter.constructorsIn(type.getEnclosedElements())) {
            if (cons.getParameters().isEmpty())
                return;
        }

        // Couldn't find any default constructor here
        processingEnv.getMessager().printMessage(
                Diagnostic.Kind.ERROR, "type is missing a default constructor",
                type);
    }

    private boolean requiresDefaultConstructor(TypeElement type) {
        // sample: require any JPA Entity to have a default constructor
        return type.getAnnotation(Entity.class)) != null
               || type.getQualifiedName().toString().contains("POJO");
    }

}