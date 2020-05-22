else if(aObj instanceof String) {
        if (aObj.toString().startsWith("/Date")) {
            System.out.println(aObj+" is Date");
        }   
        else
            System.out.println(aObj+" is String");