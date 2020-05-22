String passedInToken = "this is the token";
    String srcPath = "/pathabc";
    StringBuffer sb = new StringBuffer();
    String srcPatternString = "(src=\".*?\")";
    Pattern srcPattern = Pattern.compile(srcPatternString);

    String patternString = "(?:<img\\s)([^<]*)(?:token=\""+passedInToken+"\"\\s*)([^>]*)>";
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(htmlStr);

     while(matcher.find()) {

        String srcPart = matcher.group(1) + " " + matcher.group(2);

        StringBuffer srcSb = new StringBuffer();
        Matcher strMatcher = srcPattern.matcher(srcPart);
        while (strMatcher.find()) {
                strMatcher.appendReplacement(srcSb, strMatcher.group(1)+ srcPath);
        }
        strMatcher.appendTail(srcSb);
                String srcStr = "<img \"" + srcSb.toString() + ">";
        matcher.appendReplacement(sb, srcStr);
    }
    matcher.appendTail(sb);
    String newHtmlStr = sb.toString();