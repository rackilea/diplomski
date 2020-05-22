for (Method m1 : ms) {
    System.out.println( "METHODS " + m1.getName());
    for (Class paramC : m1.getParameterTypes()) {
        System.out.println(paramC.getName());
    }
    }