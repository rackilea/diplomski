static Random random = new Random();
public void randomQuestion(){
    boolean valid = false;
    int res = 0;
    while(!valid) {
        //generate 2 random numbers 
        int number = random.nextInt(15)+1;
        int number2 = random.nextInt(15)+1;
        //initiate result 

        //operator
        String operator =  randomOperator();

        //if operator is "+" do sum
        //otherwise do subtraction
        if (operator.equals("+")) {
            res = number+number2;
            valid = checkResult(res);
        }
        //if(operator.equals("-")) {
        else {
            res = number-number2;
             valid = checkResult(res);

        }
    }
    System.out.println(res + " is between 1-20");
}

public boolean checkResult(int res) {
     //int res = randomQuestion();
     //if the result is between 0 and 20 (inclusive)
            if (res > 0 && res <= 20) {
                return true;
            }
            else {
                //start over again with new numbers
                return false;
            }
    }
    //generate a random operator
    private String randomOperator() {
        return random.nextBoolean() ? "+" : "-";
    }
  public static void main(String[] args) {
        Example example = new Example();
        example.randomQuestion();

  }