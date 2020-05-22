@Override
    public boolean process(Set<? extends TypeElement> annotations, 
                           RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(CustomAnnotation.class);
        for(Element te : elements){
          CustomAnnotation annotation = te.getAnnotation(CustomAnnotation.class);
          String folder = annotation.folder();
          //... do sth with folder in context of te. 
          //te represent annotated method, e.g. testMethod from your example
        }
        return true;
    }