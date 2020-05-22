private static int getFactorial(int userInput){
    int ans = userInput;
    if(userInput >1 ){

    ans*= (getFactorial(userInput-1));
    }
    return ans;

}
// New method;
private static void printFactorial(int userInput){
    System.out.println("The value of " + userInput + "! is " + getFactorial(userInput));
}