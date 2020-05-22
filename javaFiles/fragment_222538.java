int pos(int value){
    return value / 64;
}
long offsetMask(int value){
    return 1L << (value % 64)
}
boolean exists(long[] index, int value) {
    return (index[pos(value)] & offsetMask(value)) != 0;
}


long[] index = new long[67108864];

//read references file
Scanner sc = new Scanner(new File("file1"));
while (sc.hasNextInt()) {
    int value = sc.nextInt();
    index[pos(value)]  |= offsetMask(value);
}

//find duplicates
Scanner sc = new Scanner(new File("file2"));
while (sc.hasNextInt()) {
    int value = sc.nextInt();
    boolean result = exists(index, value)
    if(result) {
      System.out.println("Duplicate: " + value);
    }
}