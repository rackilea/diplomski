public static String convertToMyJson(Object value) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        String resultList = mapper.writeValueAsString(value);
        resultList = "{" + resultList.replaceAll("(^\\[)|(\\]$)", "") + "}";
        System.out.println(resultList);
    }
    catch(Exception e) {
        e.printStackTrace(System.err);
    }
    return "";
}