class MyModel
{
    private String outcome;

    public void checkEvenOdd(int number){
        if(number % 2 == 0)
            outcome = "even";
        else
            outcome = "odd";    
    }

    public String getOutcome(){
        return outcome;
    }
}