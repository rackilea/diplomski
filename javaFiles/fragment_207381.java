while (tokens.hasMoreTokens()) {
        String className = tokens.nextToken();
        Class klass = Class.forName(className);
        if(!java.lang.reflect.Modifier.isAbstract(klass.getModifiers())) {
            java.lang.reflect.Constructor<?>[] constructors = klass.getConstructors();
            if(constructors.length > 0) {
                boolean foundDefaultConstructor = false;
                for(java.lang.reflect.Constructor<?> constructor: constructors) {
                    if(constructor.getParameterTypes().length == 0) {
                        foundDefaultConstructor = true;
                        break;
                    } 
                }
                if(foundDefaultConstructor) {
                    Object parser = klass.newInstance();
                    parsers.addElement(parser);
                } else {
                    System.err.println("No Default Constructor: " + className);
                }
            } else {
                System.err.println("No Public Constructors: " + className);
            }
        } else {
            System.err.println("Class is abstract: " + className);
        }
}