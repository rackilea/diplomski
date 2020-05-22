String str="2009-12-31 23:59:59 +0100";
                               /\
                               ||
                      Provide Space while providing timeZone

SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
System.out.println(mdyFormat.parse(str));