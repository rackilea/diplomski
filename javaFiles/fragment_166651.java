Constructor<MainClass>[] methods = <yourClass>.class.getConstructors();
    for (int i = 0; i < methods.length; i++) {
        Class<?>[] types = methods[i].getParameterTypes();
        System.out.println("Constructor "+i);
        for (int j = 0; j < types.length; j++) {
            System.out.println("Param Type" + types[j].getName());
        }
    }