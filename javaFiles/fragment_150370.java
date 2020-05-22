public static void main(String[] args) {

    System.out.println("Mercury radius: " + Planet.MERCURY.surfaceGravity()); // 42
    System.out.println("Planet class: " + Planet.class.getName()); //prints "com.test.Planet"

    try {
        Class<?> planet_cls = Class.forName("com.test.Planet");

        System.out.println(Planet.class); // com.test.Planet
        System.out.println(Planet.MERCURY.getClass()); // com.test.Planet$1
        System.out.println(Planet.VENUS.getClass()); // com.test.Planet

        for(Class c: Planet.class.getDeclaredClasses())
            System.out.println("Name:" + c.getName()); // wont print

        for(Field c: Planet.class.getDeclaredFields())
            System.out.println("Field Name:" + c.getName()); // MERCURY & VENUS :)

        try {
            Field mercury_field = planet_cls.getDeclaredField("MERCURY");

            Object o = mercury_field.get(null);

            System.out.println("Field class name: " + o.getClass()); // com.test.Planet$1

            try {
                Method surfaceGravity = o.getClass().getDeclaredMethod("surfaceGravity");

                System.out.println("Confirm result: " + surfaceGravity.invoke(o)); // 42!

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}