public class MyObjectDeserializer extends JsonDeserializer<MyObject>
{
    // read current MyObject json node
    JsonNode myObjectNode = jp.getCodec().readTree(jp);// this will read 
    // read "num" property into JsonNode and check what subclass was created
    JsonNode numNode = myObjectNode.get("num");
    if (numNode instanceof IntNode) {  // test if value of num is int indeed
        MyObject o = new  MyObject();
        o.num = ((IntNode)numNode).intValue();  // read int value
        o.str = ((TextNode)myObjectNode.get("str")).asText();  // this is how to read string typed property
        return o;
    } else {
        return null;  // or any default/error value
    }
}