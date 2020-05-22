@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({com.example.MyAnnotation.class})
public class MyAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                                        RoundEnvironment roundEnv) {
        //processing logic here

        //returning false means other registered processor can still
        //continue processing
        return false;
    }
}