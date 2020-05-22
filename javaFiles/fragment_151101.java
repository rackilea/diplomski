private Map mergeQueryStrings(String url, Map parameterMap) {
    Map newParameterMap = new HashMap(parameterMap);
    String queryString = getQueryString(url);
    if(queryString!=null){
        String [] params = queryString.split("&");
        for(String param:params){
            newParameterMap.put(param.split("=")[0], param.split("=")[1]);
        }
    }
    return newParameterMap;
}