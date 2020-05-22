public class AddressListConverter implements Converter<Map<String, List<LinkedHashMap>>, Map<String, AddressList>> {
@Override
  public Map<String, AddressList> convert(Map<String, List<LinkedHashMap>> stringListMap) {
      Map<String, AddressList> addressListMap = new HashMap<>();
      ObjectMapper mapper = new ObjectMapper();
      for (Map.Entry<String, List<LinkedHashMap>> entry : stringListMap.entrySet()) {
         AddressList addressList = new AddressList();
         for(LinkedHashMap map: entry.getValue()) {   
          Address address = mapper.convert(map, Address.class);
          addressList.getAddresses().add(address);
         }
          addressListMap.put(entry.getKey(), addressList);
      }
     return addressListMap;
  }

  @Override
  public JavaType getInputType(TypeFactory typeFactory) {
    return typeFactory.constructMapType(Map.class, String.class, List.class);
  }

  @Override
  public JavaType getOutputType(TypeFactory typeFactory) {
      return typeFactory.constructMapType(Map.class, String.class, AddressList.class);
  }
}