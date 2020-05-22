public class Job implements Comparable<Job>{
   private String id;
   private int arrivalTime;
   private int burstTime;

   //Getter and setters

   @Override
   public int compareTo(Job job) {
    int compareArrivalTime = ((Job) job).getArrivalTime();
    return this.arrivalTime - compareArrivalTime;
   }
}