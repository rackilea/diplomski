public class MyJsonDeserializer extends JsonDeserializer<MyObject>
{
 //Deserializer implementation
}

@JsonDeserialize(using=MyJsonDeserializer.class)
public class MyObject
{
  //MyObj properties and methos
}