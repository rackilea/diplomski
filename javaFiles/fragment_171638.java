String s = "a,b,c"; <---- String is object no need to convert

        String[] sp = s.split(",");<---- Array of String is object no need to convert

        List<String> l = new ArrayList<>();
        for (int i = 0; i < sp.length; i++) {
            l.add(sp[i]);
        }
       for (int i = 0; i < l.size(); i++) {
        System.out.print(" " + l.get(i));
       }