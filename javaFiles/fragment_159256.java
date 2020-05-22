String[][] data = new String[3][3];
    data[0][0] = "foo";
    data[1][1] = "bar";

    //data is a 3x3 array
    for (int i=0; i<data.length; i++) {
        System.out.println(Arrays.toString(data[i]));
    }
    //[foo, null, null]
    //[null, bar, null]
    //[null, null, null]