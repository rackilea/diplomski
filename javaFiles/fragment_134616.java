public static void main(String[] args) {
    String input = read();
    if(countNumbersAndLetters(input) && splitAndCheckLength(input))
        System.out.println("Good password");
    else 
        System.out.println("Bad password");
}