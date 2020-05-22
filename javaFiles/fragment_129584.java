public static void main(String[] args) {
    int[] myIntArray = new int[10];

    Arrays.setAll(myIntArray, i -> i);

    for(Integer num: myIntArray){
        myIntArray[num]=num*10;
    }

    for(int num : myIntArray){
        System.out.println("Element " + num/10 + ", value is " + num);

    }
}