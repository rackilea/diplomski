// create type info
final TypeInformation<OtherPojo> otherPojoInfo = Types.POJO(OtherPojo.class, 
    ImmutableMap.of("myMap", Types.MAP(Types.STRING, Types.STRING)));
final TypeInformation<MyPojo> myPojoInfo = Types.POJO(MyPojo.class,
    ImmutableMap.of("myList", Types.LIST(Types.STRING), "otherPojo", otherPojoInfo));

// test it
final MyPojo myPojo = new MyPojo();
myPojo.getMyList().add("test");
myPojo.getOtherPojo().getMyMap().put("ping", "pong");

final TypeSerializer<MyPojo> serializer = myPojoInfo.createSerializer(env.getConfig());
DataOutputSerializer dataOutputSerializer = new DataOutputSerializer(100);
serializer.serialize(myPojo, dataOutputSerializer);

DataInputDeserializer dataInputDeserializer = new DataInputDeserializer(dataOutputSerializer.getSharedBuffer());
final MyPojo clone = serializer.deserialize(dataInputDeserializer);
assert(myPojo.equals(clone));