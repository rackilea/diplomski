public void processArray() {
    int[] innerArray = myArr;
    int length = innerArray.length;
    for (int i=0; i<length; i++) {
        System.out.println("Next [" + i + "] is - " + innerArray[i]);
    }
}