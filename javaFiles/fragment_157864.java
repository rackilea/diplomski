import groovy.json.JsonSlurper


public static Map<String,Object> convertJsonToTemplateParam(String s) {
    Object result = new JsonSlurper().parseText(s);
    //Manipulate your result if you need to do any additional work here.
    //I.e. Programmatically determine value of hasfilters if filters != null
    return (Map<String,Object>) result;
}