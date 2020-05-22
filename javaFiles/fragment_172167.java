private String replace(String needle, String replacement, String haystack) {
    String result = "";
    int index = haystack.indexOf(needle);
    if(index==0) {
        result = replacement+haystack.substring(needle.length());
        return replace(needle, replacement, result);
    }else if(index>0) {
        result = haystack.substring(0,index)+ replacement +haystack.substring(index+needle.length());
        return replace(needle, replacement, result);
    }else {
        return haystack;
    }
}