String test = "caa,abb,ksmf,fsksf,fkfs,admkf";
        String regex = "(?<=abb),";
        String[] split = test.split(regex);
        for(String s : split){
            System.out.println(s);
        }