void setFieldWithReflection() {
    APIClass apiClass = new APIClass();
    try {
        Field fieldToEdit = apiClass.getClass().getField("privatefield");
        fieldToEdit.set(apiClass, 25);
    }
    catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
        e.printStackTrace();
    }
}