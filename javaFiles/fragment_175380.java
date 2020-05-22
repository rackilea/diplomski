{
        PropertyDescriptor desc = new PropertyDescriptor("uuid", Company.class);
        Method m = desc.getReadMethod();
        System.out.println(m.getName()); /* prints getUuid */
    }
    {
        PropertyDescriptor desc = new PropertyDescriptor("uuid11", Company.class);
        Method m = desc.getReadMethod();
        System.out.println(m.getName()); /* throws Method not found: isUuid11 */
    }