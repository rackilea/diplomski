public static class UtilClass { 
    public static com.jar1.Person definePerson1() {
       return newPerson(com.jar1.Person.class);
    }

    public static com.jar2.Person definePerson2() {
         return newPerson(com.jar2.Person.class);
    }

    public static com.jar3.Person definePerson3() {
         return newPerson(com.jar3.Person.class);
    }

    public static <T> T newPerson(Class<T> clazz) {
        try {
            T person = ConstructorUtils.invokeConstructor(clazz, null);
            BeanUtils.setProperty(person, "name", Constant.NAME);
            BeanUtils.setProperty(person, "lastName", Constant.LASTNAME);
            return person;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}