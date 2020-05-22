public class Builders {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Builder b = new Builder(123);

//    Builded instance1 = b
//      .defFlag(false)
//      .build(); // compile error

    Builder c1 = b
      .refFlag(true);

    Builded instance2 = b
      .setDeviceId("device id") // here's the magic, without this call `build` method would be unaccessible
      .build();

    Builded instance3 = b
      .refFlag(false)
      .defFlag(true)
      .setDeviceId("device id")
      .setUserId(12)
      .build();

    System.out.printf("%s\n%s\n", instance2, instance3);
  }

}

class Builded implements Cloneable {

  int clientId;

  Long userid;
  String deviceid;
  String flowid;

  boolean defFlag;
  boolean refFlag;

  public Builded(int clientId) {
    this.clientId = clientId;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return (Builded) super.clone();
  }

  @Override
  public String toString() {
    return String.format("{c: %d, u: %d, d: %s, f: %s, df: %b, rf: %b}", clientId, userid, deviceid, flowid, defFlag, refFlag);
  }

}

class Builder {

  int clientId;
  protected Builded instance;

  private Builder() {
  }

  protected Builder(int clientId) {
    this.clientId = clientId;
    prepare();
  }

  protected final void prepare() {
    instance = new Builded(clientId);
  }

  private Builded build() {
    try {
      return (Builded) instance.clone();
    } catch (CloneNotSupportedException ex) {
      throw new RuntimeException(ex);
    }
  }

  public Builder defFlag(boolean defFlag) {
    instance.defFlag = defFlag;
    return this;
  }

  public Builder refFlag(boolean refFlag) {
    instance.refFlag = refFlag;
    return this;
  }

  public SubBuilder setUserId(long userid) {
    instance.userid = userid;
    return new SubBuilder(instance);
  }

  public SubBuilder setDeviceId(String deviceid) {
    instance.deviceid = deviceid;
    return new SubBuilder(instance);
  }

  public SubBuilder setFlowId(String flowid) {
    instance.flowid = flowid;
    return new SubBuilder(instance);
  }

  public static class SubBuilder extends Builder {

    private SubBuilder(Builded instance) {
      this.instance = instance;
    }

    public Builded build() {
      return super.build();
    }

  }

}