public interface PumpEngineConnection {
  public void activate();
}

public interface FuelFacility {
  public PumpEngineConnection connect(String pumpId, String engineId);
}