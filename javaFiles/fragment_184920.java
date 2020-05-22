MyClass obj =  mapper.readValue("{ \"name\" : \"value\"}", MyClass.class);
String serialized = mapper.writeValueAsString(obj);

MyClass obj2 =  mapper.readValue("{ \"name2\" : \"value\"}", MyClass.class);
String serialized2 = mapper.writeValueAsString(obj2);

if( Objects.equals(serialized2, serialized))
    System.out.println("Success " + serialized + " == " + serialized2 );