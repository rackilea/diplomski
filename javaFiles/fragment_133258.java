public class Process implements Comparable<Process>{
   private int startTime;
   private int duration;

   public int compareTo(Process other){
       if(startTime < other.startTime) return -1;
       if(startTime > other.startTime) return 1;
       //If here, startTime == other.startTime
       if(duration < other.duration) return -1;
       if(duration > other.duration) return 1;
       return 0;
    }
}