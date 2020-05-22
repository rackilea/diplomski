public static void main(String[] args) throws Exception {
        ArrayList<String[]> listOfStringArrays = new ArrayList<String[]>();
        listOfStringArrays.add(new String[] {"x","y","z"});
        listOfStringArrays.add(new String[] {"a","b","c"});
        listOfStringArrays.add(new String[] {"m","n","o"});
        Collections.sort(listOfStringArrays,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[1].compareTo(otherStrings[1]);
            }
        });
        for (String[] sa : listOfStringArrays) {
            System.out.println(Arrays.toString(sa));
        }
        /* prints out 
          [a, b, c]
          [m, n, o]
          [x, y, z]
        */ 

    }