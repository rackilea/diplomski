private String postNotice() {
    // Your POJO Class();
    // the Data to be Posted using the PojoClass Object;

    return new Gson().toJson(pojoClassObject);
}