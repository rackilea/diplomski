public static class Foo {                                                                                   
  public interface Service { }                                                                          

  public interface CarWash extends Service {                                                            
    void washCar();                                                                                     
  }                                                                                                     

  public interface CarRepair extends Service {                                                          
    void repairCar();                                                                                   
  }                                                                                                     

  static <T extends Service, S extends T> void addService(S service, Class<T> clazz) {}                 

  public static void main(String[] args) {                                                              
    addService(null, CarWash.class);  // Fine.                                                                  
    addService(null, Object.class);   // Compilation error.                                                          
  }
}