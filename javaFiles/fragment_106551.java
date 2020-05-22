public class MyMockPolicy implements PowerMockPolicy {

  public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
    settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(Holder.class.getName());
  }

  public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {
    Method getDataMethod = Whitebox.getMethod(Holder.class);
    DataObject dataObject = new DataObject(); //custom object
    settings.addSubtituteReturnValue(getDataMethod, dataObject);      
  }