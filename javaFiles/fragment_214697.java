String[][] one = // your 1st array here;
    String[][] two = // your 2nd array here;
    String[][] three = // your 3rd array here;
    String[][] four = // your 4th array here;
    // This works with an arbitrary amount of arrays.
    String[][] merged1 = mergeArrays(String.class, one, two, three);
    String[][] merged2 = mergeArrays(String.class, one, two, three, four);