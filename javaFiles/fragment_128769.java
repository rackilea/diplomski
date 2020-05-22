import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class DeserializerTest {
    public static void main(String[] args)
    {
        JSONSerializer serilizer = new JSONSerializer();
        Apple oneApple = new Apple(123);
        String appleString = serilizer.serialize(oneApple);

        // Convert Apple String to Apple object here
        Apple deserializedApple = new JSONDeserializer<Apple>().deserialize( appleString );
        System.out.println("AppleID: "+deserializedApple.appleID);
    }
}