public class ChatBot {
String response;
public static void main(String[] args) throws Exception {
    ChatBot c1 = new ChatBot();
    String qry1 = c1.getResponse("total_market_cap_usd");
    System.out.println("response: "+qry1);
}
public static class MyData {
    String total_market_cap_usd;
    String total_24h_volume_usd;
}
public String getResponse(String query) {
    URL url = null;
    try {
        url = new URL("https://api.coinmarketcap.com/v1/global/");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        MyData data = new Gson().fromJson(reader, MyData.class);
        switch (query) {
        case "total_market_cap_usd":
            response = data.total_24h_volume_usd;
            break;
        case "total_24h_volume_usd":
            response = data.total_24h_volume_usd;
            break;
        default:
            throw new IllegalArgumentException("Query not recognized!");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return response;
}
}