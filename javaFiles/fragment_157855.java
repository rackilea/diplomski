public boolean myStartsWith(String testString, String startsWith) {

    for (Map.Entry<String,String> me : fancyTransformMap) {
       startsWith = startsWith.replaceAll(me.getKey(), me.getValue());
    }

    return testString.matches('\b' + startsWith);
}