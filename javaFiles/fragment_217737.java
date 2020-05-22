public class Example {

    private char[] correctAnswers;
    private char[] studentAnswers;

    private int[] missed; // here you're defining the array, this can be used throughout the class.

    private int count = 0;

    // Constructor accepts an array of answers from the other program.
    public Example(char[] answers) {
        correctAnswers = new char[]{'a', 'b', 'c'}; // Here, don't call char[] again because you've already defined this array as char[] earlier
        int question_number = 1;
        missed = new int[0]; // here you are initialising the array with 3 elements

        // Copy answers array to studentAnswers array
        *Insert code here 

        //Using a for loop I Compare the two arrays studentAnswers and 
        //correctAnswers and increment variables count and question_number
        //and if a question is wrong I populate the missed array with 
        // the question_number
        *Insert code here*

        for(int i=0; i<studentAnswers.length(); i++){

            if(studentAnswers[i] != correctAnswers[i]){
                missed = addElement(missed, i); // Adding an element to the list, this isn't a good way to do it
            }

        }

    }

    public int totalCorrect() {
        return count;
    }

    public int[] totalIncorrect() {
        incorrect = 3 - count;
        return incorrect;
    }

    // This method can't accept any arguments
    public int[] questionsMissed() {
        try {
            return missed;  // You can access this, and return only if it has been initialised before accessing this method.
        } catch(NullPointerException e){
            System.out.println("the array wasn't initialised before accessing this method")
        }
    }

    /**
      * This method just takes the current array, makes a new one and adds an element to it, it's mocking Collections.add(E e) 
    */
    static int[] addElement(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

}