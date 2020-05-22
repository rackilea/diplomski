Pattern p = Pattern.compile("([\\D]*)([\\d]*)");
        Matcher m = p.matcher("upload completed12345");
        while (m.find()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }