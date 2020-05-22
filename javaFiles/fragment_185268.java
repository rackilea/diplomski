String str="\"000ABCD\",000,HU,4614.850N,02005.483E,80.0m,5,160,1185.0m,,005,4619.650N,01958.400E,87.0m,1";
    Pattern p = Pattern.compile("\"(.*?)\"");
    Matcher m = p.matcher(str);
    while (m.find()) {                     
        System.out.println(m.group(1));
    }