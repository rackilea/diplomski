@Override
public Serializable fromRequestId(String id, Class<?> aClass) {
    if(id==null) {
      return null;
    }
    String[] parts = id.split("_");
    return new EmployeeIdentity(parts[0], parts[1]);
}