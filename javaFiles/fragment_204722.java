import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Example {

    public static void main(String[] args) {

        //String jsonString = "{\"result\":[{\"sentence\": \"Chinese government cafes people cafe crackdown\", \"id\": 1, \"txtfile\": \"002.txt\"}, {\"sentence\": \"kalf alo ldk alf\", \"id\": 2, \"txtfile\": \"003.txt\"}]}";

        String jsonString = readJsonFile("filePath");

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray result = jsonObject.getJSONArray("result");
            for (int i =0; i < result.length(); i++){
                JSONObject j = result.getJSONObject(i);
                String s = j.getString("sentence");
                int id = j.getInt("id");
                String txtFile = j.getString("txtfile");
                System.out.println("Sentence is " + s);
                System.out.println("Id is " + id);
                System.out.println("text file is " + txtFile);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String readJsonFile(String filePath) {
    String jsonData = "";
    BufferedReader br = null;
    try {
        String line;
        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
            jsonData += line + "\n";
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    return jsonData;
}
}