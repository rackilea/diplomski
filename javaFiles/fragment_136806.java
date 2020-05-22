Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1int = Integer.parseInt(s1.substring(0, s1.indexOf(",")));
                int s2int = Integer.parseInt(s2.substring(0, s2.indexOf(",")));
                return s1int - s2int;
            }
});