String str = "   This       is\r\n    " + 
        "\r\n" + 
        "   \r\n   " + 
        " \r    \n   \n  " +
        "\r\n" + 
        "                a        string.   ";
str = str.trim().replaceAll("(?m)(^ *| +(?= |$))", "").replaceAll("(?m)^$([\r\n]+?)(^$[\r\n]+?^)+", "$1");
System.out.println(str);