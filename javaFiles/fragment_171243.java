Unsafe unsafe = ...; // Obtain the value of the sun.misc.Unsafe.theUnsafe field, using normal reflection
    try
    {
        Object o = unsafe.allocateInstance(TestEnum.class); // creates a new instance of TestEnum with all fields set to 0 / false / null
        System.out.println(o); // prints 'null' because the name field is null
        System.out.println(o.getClass()); // prints 'JavaTest$Enum'

        Field f = Enum.class.getDeclaredField("name");
        f.setAccessible(true); // bypasses the final and access checks
        f.set(o, "TEST"); // set the name to 'TEST'
        f = Enum.class.getDeclaredField("ordinal");
        f.setAccessible(true);
        f.set(o, 1); // set the ordinal to 1

        System.out.println(o); // prints 'TEST'
        System.out.println(((Enum) o).ordinal()); // prints 1
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }