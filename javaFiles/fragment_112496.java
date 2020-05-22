public static void main(String[] args) {

     System.out.println("Input up to '10' numbers for current array: ");

        //Declaring array1 and scanner
        int[] array1 = new int[10];
        int i;
        Scanner scan = new Scanner(System.in);

        //Your loop to ask for data into array1
        for (i = 0; i < array1.length; i++) {
            System.out.print((i+1)+": ");
            int input = scan.nextInt();
            if (input == 0) {
                break;
            } else {
                array1[i] = input;
            }
        }

        //Copy array1 into array2
        int[] array2 = new int[i];

        for(int j=0; j<i;j++){
            array2[j] = array1[j];
        }

        //array2 = Arrays.copyOf(array1, i);
        // array2 = copy(array1, i);

        //Print out the second array, only for test
        for (int j = 0; j < array2.length; j++) {
            System.out.println(array2[j]);
        }

        scan.close();
}


public static int[] copy(int [] source, int len){
    int [] target = new int[len];
    for(int i=0; i<len;i++){
        target[i] = source[i];
    }

    return(target);
}