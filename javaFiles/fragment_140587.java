public abstract class SoftwareComponent<I extends Information> {

  private Set<I> generateInfo = new HashSet<I>();
  private Set<I> consumeInfo = new HashSet<I>();
  public Set<I> getGeneratedInfo() { ... }
  public Set<I> getConsumedInfo()  {....}
}

public class SensorDriver extends SoftwareComponent<SensorMeasurement> {
}