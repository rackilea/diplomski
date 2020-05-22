static int findRegex(String needle, String haystack) {

    String regex = needle.replace("_", ".{0,10}?");
    //System.out.println(regex);

    Matcher matcher = Pattern.compile(regex).matcher(haystack);
    if (matcher.find()){
        return matcher.start();
    }else{
        return -1;
    }
}