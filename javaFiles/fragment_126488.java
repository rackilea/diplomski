public static String getSkinPath( Class<?> cls ){
    Pattern pattern = Pattern.compile("org.*INF.?.(jsp|tiles).(.*?)_jsp");

    String name = cls.getName();

    Matcher matcher = pattern.matcher(name);

    if( matcher.matches() ){
        String type = matcher.group(1);
        String path = matcher.group(2).replace(".", "/");

        //fullPath is the value we're looking for int he original question
        String fullPath = type.concat("/").concat(path).concat(".jsp");

        return getSkinPath(fullPath);
    }else{
        return "";
    }

}