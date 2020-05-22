Scanner in = new Scanner(System.in);

    int[] seq1 = new int [10];
    int[] seq2 = new int [2];
    int[] seq3 = new int [4];

    int i;
    Integer max1, max2, max3;

    //SEQ1

    max1=null;
    for(i = 0; i < seq1.length; i++ ) {
        seq1[i] = in.nextInt();
        if (max1 == null || seq1[i] > max1) max1 = seq1[i];
    }

    //SEQ2

    max2=null;
    for(i = 1; i < seq2.length; i++) {
        seq2[i] = in.nextInt();
        if (max2 == null || seq2[i] > max2) max2 = seq2[i];
    }

    //SEQ3

    max3=null;
    for(i = 0; i < seq3.length; i++ ) {
        seq3[i] = in.nextInt();
        if (max3 == null || seq3[i] > max3) max3 = seq3[i];
    }


    System.out.println(max1);
    System.out.println(-(max2));
    System.out.println(max3);