public Lottery() {
    java.util.Random iRandom = new java.util.Random();
    int num[] = new int[6];
    //java.util.Arrays.sort(num);

    for(int i =0 ; i < num.length; i++) {
        num[i] = iRandom.nextInt(49)+1;
    }

    java.util.Arrays.sort(num);

    for(int i : num) {
        System.out.println(i);
    }
}