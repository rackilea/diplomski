import java.util.Arrays;

public class TestStopWatch {
    public static void main(String args[]){

        StopWatch sw=new StopWatch();

        long p=sw.start(); // trying to call the start method in the previous class

        // code to create and sort array

        long q=sw.stop(); //stop method in previous class

        // call getElapsedtime and print
        System.out.println(sw.getElapsedTime((double)q,(double)p));

    }
}