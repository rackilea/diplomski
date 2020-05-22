public static Map<String, Object> returnLogoPutAsParam() {
    Map<String, Object> parameters = new HashMap<>();
    InputStream logo = returnLogoByte();
    parameters.put("logo", logo);
    return parameters;
}