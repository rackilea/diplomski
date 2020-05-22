interface MyInterface {
}

interface MyInterfaceFactory {

    MyInterface newInstance();
}

class MyInterfaceFactoryFromProperties implements MyInterfaceFactory {

    final Class<? extends MyInterface> myInterfaceImpl;

    {
        final Properties properties = new Properties();
        try {
            properties.load(MyInterfaceFactoryFromProperties.class.getResourceAsStream("className.properties"));
        } catch (IOException ex) {
            throw new ExceptionInInitializerError(ex);
        }
        final String className = properties.getProperty("class.name");
        try {
            myInterfaceImpl = (Class<? extends MyInterface>) MyInterfaceFactoryFromProperties.class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public MyInterface newInstance() {
        try {
            return myInterfaceImpl.newInstance();
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}