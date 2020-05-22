try {
        boolean hasParens = false;
        String s = "123,456";
        s = s.replaceAll(",","")

        if(s.contains("(")) {
            s = s.replaceAll("[()]","");
            hasParens = true;
        }

        int number = Integer.parseInt(s);

        if(hasParens) {
            number = -number;
        }
    } catch(...) {
    }