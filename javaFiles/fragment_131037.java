public class CrapsGame {

    public static void main(String[] args) {

        // Create some variables to control the times it won and times it lost
        int timesWon = 0;
        int timesLost = 0;


        // Here we're saying it's gonna repeat 10000 times, incrementing 1 by 1
        for(int i=0; i<10000; i++) {
            // Here you will insert all the existing logic from your program

            // In the existing code, increment the variables declared according

            if(roll == 2 || roll == 3 || roll == 12){
                System.out.println("You Lose !");
                timesLost++;
            }else if(roll == 7 || roll == 11){
                System.out.println("You Win !");
                timesWon++;
            }else{
                // Where you find it won, insert `timesWon++;`
                // Where you find it lost, insert `timesLost++;`
            }
        }
        // Here it exits the for loop (after 10000 times)
        // Here's where you can calculate

        System.out.println("Probability of winning: " + (timesWon/(timesWon + timesLost)));
    }
}