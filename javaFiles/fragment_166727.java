public class Xml2json {

    static String line="",str="";
    public static void main(String[] args) throws JSONException, IOException {
        String link = "data.xml";
        BufferedReader br = new BufferedReader(new FileReader(link));
        while ((line = br.readLine()) != null) 
        {   
            str+=line;  
        }
        JSONObject jsondata = XML.toJSONObject(str);
        System.out.println(jsondata);
    }
}