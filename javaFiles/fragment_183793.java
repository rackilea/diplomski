String regex = "(\\/\\*(?>[^\\/\\*\\*\\/]+)*\\*\\/)";
    String str="this /* asdas/* extra commen/*   asdas  */  ts */da */ is test /* asdas */ asdasd ";;

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(str);
    while (m.find()) {
        str = m.replaceFirst("");
        m = p.matcher(str);
        System.out.println(str);
    }

    // here your string is 
    // this  is test  asdasd