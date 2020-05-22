public static date  parseJSON(String jsonArray) {
    date yourDate = new date();
    try {
        yourDate = (gson.fromJson(jsonArray, date.class));

    } catch (Exception e) {
        e.printStackTrace();
    }
    return yourDate;
}