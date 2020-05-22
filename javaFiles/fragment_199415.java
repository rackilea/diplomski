String str= "SomeName_Some1_Name2_SomeName3";
        Pattern ptrn= Pattern.compile("SomeName");
        Matcher matcher = ptrn.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }