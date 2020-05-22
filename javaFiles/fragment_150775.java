import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class TestClass {
    public static void main(String[] args) throws Exception {
        String jsonString = "{\n" +
                " \"abc:def\": {\n" +
                "      \"ghi\": {\n" +
                "         \"jkl\": \"{\\\"mno:pqr\\\":{\\\"ty\\\":4,\\\"\\\\nsensing_service_name:\\\\\\\"Number\\\\\\\",\\\\nsensing_service_id: 20\\\\n}\\\\n     ]\\\\n}\\\"}}\",\n" +
                "         \"st\": {\n" +
                "            \"op\": 5,\n" +
                "            \"org\": \"q9wr9qrq\"\n" +
                "         },\n" +
                "         \"uvw\": 1\n" +
                "      },\n" +
                "      \"xyz\": false\n" +
                "   }\n" +
                "} ";

        JSONObject jsonObject = new JSONObject(jsonString);
        jsonObject = (JSONObject) jsonObject.get("abc:def");
        jsonObject = (JSONObject) jsonObject.get("ghi");
        String result = jsonObject.getString("jkl");
        result = StringUtils.replace(result, "\\n", "");
        System.out.println(result.replaceAll("\\\\",""));
    }
}