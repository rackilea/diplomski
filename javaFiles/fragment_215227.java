package stackOverflowTests;

import java.util.Scanner;

public class simpleGame {
    public static class UserInput extends Thread {

        volatile private int answer;

        public void run() {
            Scanner in = new Scanner(System.in);
            while(true){
                System.out.print("Answer meeee!:");
                answer = in.nextInt();
            }
        }

        public int getAnswer(){
            return answer;
        }
    }
    public static void play() throws InterruptedException {

        UserInput testInput = new UserInput();
        testInput.start();
        while(true){
            //PrintChallenge() prints an operation and store its result on game
            Thread.sleep(10);
            if(testInput.getAnswer()==30)System.out.println(testInput.getAnswer()+ " : "+(testInput.getAnswer()==10));
        }
    }

    public static void main(String[] args) throws InterruptedException{
        play();

    }
}