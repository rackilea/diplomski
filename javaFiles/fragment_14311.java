public class AnnotationProcessor extends AbstractProcessor {
......
    @Override
     public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

         Set<? extends Element> rootE=roundEnv.getRootElements();
         for(Element e: rootE) {
             for(Element subElement : e.getEnclosedElements()){
                 subElement.accept(new ExampleVisitor(), null); // implement ExampleVisitor
             }
        }
    }
}