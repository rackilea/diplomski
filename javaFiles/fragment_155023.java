String[][] array = new String[][] { { "a", "b", "c" }, { "a" }, { "a", "b" }, { "a", "c" } };

        Arrays.sort(array, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {

                for (int i = 0; i < o1.length; i++) {

                    if (o2.length == i) return 1;

                    int comp = o1[i].compareTo(o2[i]);

                    if (comp != 0)
                        return comp;   
                }                           
                return -1;
            }
        });