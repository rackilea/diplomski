private void showRequestParamaters(HttpServletRequest req) {
    Map<String, String[]> parameterMap = req.getParameterMap();
    List<String> requestParams = new ArrayList<>();
    for (Entry<String, String[]> entry : parameterMap.entrySet()) {
        String[] paramValues = entry.getValue();
        if (paramValues != null) {
            for (String p : paramValues) {
                requestParams.add(p);
            }
        }
    }
    for (String s : requestParams) {
        System.out.println(s);
    }
}