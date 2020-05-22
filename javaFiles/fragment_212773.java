public class VehicleStatus{

   }

   public interface SimulationState {
      Iterable<? extends VehicleStatus> getVehicleStatuses();
   }

   public interface SimulationStateDec<V extends VehicleStatus> extends SimulationState {
     @Override
     public Iterable<V> getVehicleStatuses();
   }