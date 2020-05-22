public class TransportMarshaller implements DynamoDBMarshaller<List<Transport>> {

@Override
public String marshall(List<Transport> transports) {
    List<String>transportMap=new ArrayList<>();
    for(Transport transport:transports){
        transportMap.add(transport.name());
    }
    return transportMap.toString().replaceAll("\\[|\\]", "");//Save as comma separate value for the purpose of easiness to unmarshall
}

@Override
public List<Transport> unmarshall(Class<List<Transport>> aClass, String s) {
    List<String>map= Arrays.asList(s.split("\\s*,\\s*")); //split from comma and parse to List
    List<Transport>transports=new ArrayList<>();
    for (String st:map){
        transports.add(Transport.valueOf(st));
    }
    return transports;
}
}