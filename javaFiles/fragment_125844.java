public class MyBizParser {
    public static void main(String[] args)
    {
        String yourJson = 
            "["
            + "{\"srno\":\"1\",\"itemcode\":\"4545\",\"type\":\"45454\",\"subtype\":\"54\",\"sku\":\"45\",\"invqty\":\"54\",\"invprice\":\"54\",\"discount\":\"5\",\"total\":\"45\"},"
            + "{\"srno\":\"2\",\"itemcode\":\"44\",\"type\":\"54\",\"subtype\":\"45\",\"sku\":\"45\",\"invqty\":\"4\",\"invprice\":\"54\",\"discount\":\"54\",\"total\":\"5\"}"
            + "]";

        parsingIt(yourJson);
    }

    private static void parsingIt(String yourJson) {
        ObjectMapper objMapper = new ObjectMapper();

        try {
            MyJsonClass[] myObjects = objMapper.readValue(yourJson, MyJsonClass[].class);

            for(int i = 0; i < myObjects.length; i++)
                System.out.println(myObjects[i]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}