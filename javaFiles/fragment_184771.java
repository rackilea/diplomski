private static Attribute createAttributeStub() {
    try {
        Constructor<Attribute> constructor = 
                Attribute.class.getDeclaredConstructor(String.class, String.class, 
                        Date.class, String.class);
        constructor.setAccessible(true);
        return constructor.newInstance("fake", "fakeName", 
                new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2019"), "fake Metadata");
    }
    catch( ReflectiveOperationException | ParseException e ) {
        throw new RuntimeException(e);
    }
}