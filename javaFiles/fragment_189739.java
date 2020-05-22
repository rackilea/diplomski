public static String toQueryString(Map<String, String[]> params) {
    StringBuilder queryString = new StringBuilder();

    for (Entry<String, String[]> param : params.entrySet()) {
        for (String value : param.getValue()) {
            if (queryString.length() > 0) {
                queryString.append("&amp;");
            }

            queryString
                .append(URLEncoder.encode(param.getKey(), "UTF-8"))
                .append("=")
                .append(URLEncoder.encode(value, "UTF-8"));
        }
    }

    return queryString.toString();
}