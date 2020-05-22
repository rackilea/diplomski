int[] longArray = { 1, 3, 2 };
    int[] shortArray = { 1, 2 };

    //Check which array is longer, if b longer than a then swap

    for (int x:longArray){
        set.add(x);
    }
    for (int x:shortArray){
        if (set.contains(x))
           set.remove(x);
    }
    //odd numbers
    for (Object i:set.toArray())
        System.out.println(i+",");