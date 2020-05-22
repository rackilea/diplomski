String str = "a,b,c,d,,,e,f,g";
    String regex = "(?<!,),|,(?!,)";

    for(String s : str.split(regex)) {            
        System.out.println(s);
    }