public class NumberGame {

    //instance variable
        private int upperLimit;
        private int number;
        private int guess = 1; //number of guesses to 1

    //constructor
    public NumberGame(int upperLimit){

           this.upperLimit = upperLimit;
           this.number = generateNumber() //or some method you are using to generate the number for the user to guess
        }
    }