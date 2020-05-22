String[][] theArray = new String[][]{{"Enter values","Enter values"}, {more values, more values}};
Comparator<String[]> comparator= new Comparator<String[]>() {
       Arrays.sort(theArray, new Comparator<String[]>(){
                @Override
                public int compare(String[] o1,  String[] o2) {
                    return o1[0].compareTo(02[0]);
                }
            });
 Arrays.sort(theArray, comparator);