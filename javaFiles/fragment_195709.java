public static void main (String[] args) throws java.lang.Exception
    {
        String str = "${URL:URL=https://example.com/private/imgs/ROHAN_ZAVERI.jpg}";
        String patternstr = "https?[^}]*(?=})";

        Pattern pattern = Pattern.compile(patternstr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
        System.out.println(matcher.group(0)); 
        } 
    }