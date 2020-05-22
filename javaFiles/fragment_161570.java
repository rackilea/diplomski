public static void main(String[] args) {
    // Your scanner code here.
    int answer = processAndReturn(int1, int2);
    System.out.println("Larger Integer: " + answer);
    int lastDigit = processLargerInt(answer);
    System.out.print("Last Digit: " + lastDigit);
}

public static int processAndReturn(int int1, int int2){
   return Math.max(int1, int2);
}

public static int processLargerInt(int answer) {
   return answer % 10;
}