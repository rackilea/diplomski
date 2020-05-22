import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App
{
   public static void main(String[] args) throws IOException  
    {
        URL url = new URL("http://api.bitcoincharts.com/v1/markets.json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        TypeToken<List<MyJsonClass>> token = new TypeToken<List<MyJsonClass>>(){};
        List<MyJsonClass> list = new Gson().fromJson(isr, token.getType());

        for (MyJsonClass mjc : list)
        {
            System.out.println(mjc.symbol + " : " + mjc.latest_trade);
        }
    } 
}

// No getters / setters for simple example
class MyJsonClass
{

    /*
    {"volume": 8.621800000000, "latest_trade": 1389906326,
        "bid": 11149.760000000000, "high": 10794.930000000000, 
        "currency": "ZAR", "currency_volume": 88097.489637000000, 
        "ask": 9722.590000000000, "close": 10350.000000000000, 
        "avg": 10217.99272042960866640376719, "symbol": "localbtcZAR", 
        "low": 9262.100000000000}
     */

    public double volume;
    public int latest_trade;
    public double bid;
    public double high;
    public String currency;
    public double currency_volume;
    public double ask;
    public double close;
    public double avg;
    public String symbol;
    public double low;
}