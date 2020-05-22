Collections.sort(mArrayList, new Comparator<String>() {
            public int compare(String s1, String s2) {
               Integer i1 = Integer.parseInt(s1.split("test ")[1]);
               Integer i2 = Integer.parseInt(s2.split("test ")[1]);
                return i1.compareTo(i2);
            });