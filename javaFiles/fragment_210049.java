class Occupancy {
   private LocalDateTime timeStamp;
   private double occupied;

   public Occupancy(LocalDateTime ts, double occ) {
       this.timeStamp = ts;
       this.occupied = occ;
   }
}