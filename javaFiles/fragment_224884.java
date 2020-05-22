String logheader = "(?<=LOGHEADER\\[START\\]/-->).*(?=<!--LOGHEADER\\[END\\])";
        Pattern p = Pattern.compile(logheader, Pattern.DOTALL);
        Matcher m = p.matcher(fileContent);
        while(m.find()) {
         System.out.println(m.group());
       }