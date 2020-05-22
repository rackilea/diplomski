Param0 = Integer.parseInt(TableElements[i].substring(TableElements[i].indexOf("(") + 1, TableElements[i].indexOf(",")));
    System.out.println(Param0);
    Param1 = Integer.parseInt(TableElements[i].substring(TableElements[i].indexOf(",") + 2, TableElements[i].lastIndexOf(",")));
    System.out.println(Param1);
    Param2 = Integer.parseInt(TableElements[i].substring(TableElements[i].lastIndexOf(",") + 2, TableElements[i].indexOf(")")));
    System.out.println(Param2);