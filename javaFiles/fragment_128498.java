int max = 22;
    int count = 0; // count number of B's
    String x[] = new String[22];
    int i = 4; // starting index
    while (count < 11) {
        x[i] = "B";
        count++;
        int c = 0;
        // we will take five steps to find new index
        while (c < 5) {
            i++;
            i%=22;
            if(x[i] == "B") ; // dont count it as step if its already B
            else c++;
        }

    }
    // fill with G
    for (i = 0; i < 22; i++) {
        if (x[i] != "B")
            x[i] = "G";
    }

    System.out.println(Arrays.toString(x));