String str = "this/iss/the/root/assets/images/icons/parent/child";
    String root = "this/iss/the/root/";
    String rootRegex = root.replace("/", "\\/"); //escape fwd slashes
    String ptrnStr = "^" + rootRegex + "(.+)child\\Z";
    java.util.regex.Pattern ptrn = Pattern.compile(ptrnStr); 

    java.util.regex.Matcher mtchr = ptrn.matcher(str);

    if(mtchr.find())
    {
        String between = mtchr.group(1);
        System.out.println("FOUND:  " + between);
    }