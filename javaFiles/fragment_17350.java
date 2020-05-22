public class Agent {
   int lastFinishTime;

   boolean isCompatibleWith(WareHouse x) {
      return x.startTime > lastFinishTime;
   }

   boolean scheduleWareHouse(WareHouse x) {
      lastFinishTime = x.endTime;
   }
}