private Messager messager;
private Types typeUtils;
private Elements elementUtils;

@Override
public synchronized void init(ProcessingEnvironment processingEnv) {
    messager = processingEnv.getMessager();
    typeUtils = processingEnv.getTypeUtils();
    elementUtils = processingEnv.getElementUtils();
}