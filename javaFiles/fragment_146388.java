public static JSONArray arrayToJson(double[] array) throws JSONException {
    return Arrays.stream(array).collect(
            JSONArray::new,
            JSONArray::put,
            JSONArray::put
    );
}