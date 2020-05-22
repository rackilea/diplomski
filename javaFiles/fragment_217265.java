Pattern pattern = Pattern.compile("(\"[^\"]*\")|(\\w+)|(,)");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            if(matcher.group(2)!=null)
            System.out.println(matcher.group(2));
            if(matcher.group(1)!=null)
            System.out.println(matcher.group(1));
            if(matcher.group(3)!=null)
            System.out.println(matcher.group(3));
        }