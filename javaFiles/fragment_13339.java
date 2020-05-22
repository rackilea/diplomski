public void updateDatabasePrep(Car carObject){
    NewObject myObject = new NewObject(); //Initialized, but empty

    try {
        copyIfSpecified(carObject, myObject, "milage");
        copyIfSpecified(carObject, myObject, "color");
        copyIfSpecified(carObject, myObject, "name");
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
        throw new RuntimeException("Error while populating fields", ex);
    }
}