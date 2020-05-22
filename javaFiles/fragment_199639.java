public class ArraysFun{
    private static int[] timeouts = {1000,2000,3000,3500};
    public static void main(String[] sss){
        endlessCounter(0);
    }
    //Endless counter that calls your function
    public static void endlessCounter(int i){
        long start = System.currentTimeMillis();
        long now;
        do{
            now = System.currentTimeMillis();
        //checks to see if the time was elapsed
        }while(now - start<timeouts[i]);
        //call your function
        callFunction(i);
        //iterate through the timeouts array
        i = (i>= timeouts.length-1)? 0 : i+1;
        //call the counter again
        endlessCounter(i);
    }
    //just print which is the timeout that was waited before this call
    private static void callFunction(int i) {
        double duration = (double)timeouts[i]/1000.00;
        System.out.println("Function called after "+ duration + " seconds");
    }
}