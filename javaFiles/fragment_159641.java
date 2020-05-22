public class MultiplesOfThreeAndFive {

    public static void main(String[] args) {
        //For a number to be a multiple, i % number equals 0.
        MultiplesOfThreeAndFive m = new MultiplesOfThreeAndFive();

        int sum = 0;
        for (int i = 1; i < 1000; i++){
            if (m.checkIfMult(i))
            {
                sum = sum + i;
            }
        }
        System.out.println("Sum is: " + sum);
    }

    public boolean checkIfMult(int i){
        return (i % 3 == 0 || i % 5 == 0);
    }
}