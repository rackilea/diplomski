final String[] s = { "2 nd blah", 
                "1st foo", 
                "foo 2nd bar", 
                "blahblah1stfounditimmediately", 
                "blah 3rd foo", 
                "blah55th foo", 
                "66 th bar"
                 };
        final Pattern p = Pattern.compile("(1 ?ST|2 ?ND|3 ?RD|\\d+ ?TH)");
        Matcher m = null;
        String t;
        for (final String x : s) {
            t = x.toUpperCase();
            m = p.matcher(t);
            while (m.find()) {
                System.out.println(x + " ---> " + t.replaceAll(m.group(1), m.group(1).toLowerCase()));
            }
        }