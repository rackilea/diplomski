public static void main(String[] args) {
    int[] number = new int [10];
    printReverse(reverseNumbersWhile(number));
}
public static int[] reverseNumbersWhile(int[] input){
    System.out.println("Enter 10 numbers : ");
    Scanner in = new Scanner(System.in);
    for (int i = 0; i < input.length; i++){
      input[i] = in.nextInt();
    }  
    //System.out.println(input);
    return input;
}

public static void printReverse(int[] value){
    for (int i = value.length - 1; i >=0; i--){
      System.out.print(value[i] + " ");
}