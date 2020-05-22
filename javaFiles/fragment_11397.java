String flags[] = {"9","0","23","25","34","1","9","12","13","0","67","2","43"};
    String array[] = new String[flags.length];
    String zeros [] = new String[array.length];
    String ones[] = new String[array.length];

    int i;

    boolean addingZeroes = false;
    boolean addingOnes = false;
    int zeroCount = 0;
    int onesCount = 0;

    for (i = 0; i<flags.length; i++) {

        if (flags[i].equals("0")) {
            zeros[zeroCount] = flags[i];
            zeroCount++;
            addingZeroes = true;
            addingOnes = false;
        } else if (flags[i].equals("1")) {
            ones[onesCount] = flags[i];
            onesCount++;
            addingZeroes = false;
            addingOnes = true;
        } else if (addingZeroes) {
            zeros[zeroCount] = flags[i];
            zeroCount++;
        } else if (addingOnes) {
            ones[onesCount] = flags[i];
            onesCount++;
        }

    }

    for(i=0; i<zeroCount; i++) {
        System.out.println(zeros[i]);
    }

    System.out.println();

    for(i=0; i<onesCount; i++) {
        System.out.println(ones[i]);
    }