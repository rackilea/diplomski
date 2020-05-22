String s = "INSERT INTO `mtable` VALUES (639383,-216,-398,1,174431,'test , test',1239629);";

    s = s.replaceAll(".*\\((.*)\\);", "$1");

    String[] strs = s.split("'");

    for (String string : strs) {
        if(string.endsWith(",") || string.startsWith(",")) {
            String[] splits = string.split(",");
            for (String string2 : splits) {
                if(string2!=null && string2.trim().length()!=0) {
                    System.out.println(string2);
                }
            }
        } else {
            System.out.println(string);
        }
    }