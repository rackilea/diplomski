public interface MetaEnum {
  String getValue();  

  default String getKey() {
    return (this.getClass().getPackage().getName() + "." + 
            this.getClass().getSimpleName() + "." +
            this.toString()).toLowerCase();
  }
}