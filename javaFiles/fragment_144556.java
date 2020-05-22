import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class Variables {

    public static final String DB_URL = "jdbc:mysql://160.153.49.168:3306/btcprogram";

    //  Database credentials
    public static final String USER = "sully";
    public static final String PASS = "asweq123e";

    //Web Elements
    public static URL url = null;
    public static Document page = null;
    public static Element priceElement = null;
    public static Document doc = null;
    public static String price;
    public static String priceString;


    public static String coinbaseURL = "https://bitcoinwisdom.com/markets/coinbase/btcusd";
    private Connection connection;


    //Sets the URL
    public void setURL(String siteURL) throws IOException {
        url = new URL(siteURL);
    }


    public Double getCoinbase() throws IOException {

        try {
            setURL(coinbaseURL);

            page = Jsoup.parse(url, 5000);
            if (page.select("div.green").first() == null) {
                priceElement = page.select("div.red").first();
            } else {
                priceElement = page.select("div.green").first();
            }

            priceString = priceElement.toString();
            doc = Jsoup.parse(priceString);
            price = doc.body().text();


        } catch (IOException e) {
            System.out.println("something went wrong");
            System.out.println(e.getMessage());
        }
        return Double.parseDouble(price);
    }

    public void addPrice(Double price, String market, Double priceChange) {
        /**
         * In your table set the time of change to a default value, so the table will do the time itself.
         * Makes it easier for you and doesn't get complicated if you want to get others to insert prices.
         */
        this.query("INSERT INTO prices (market, price, pricechange) VALUES (?, ?, ?)", new Object[]{
                price, market, priceChange
        });
    }

    public ResultSet query(String q, Object[] args) {
        if (connection == null) {
            System.out.println("No connection to the database.");
            return null;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            for (int i = 1; i <= args.length; i++) {
                if (args[i] instanceof Double){
                    preparedStatement.setDouble(i, Double.parseDouble(String.valueOf(args[i])));
                }else{
                    preparedStatement.setString(i, String.valueOf(args[i - 1]));
                }
            }
            if (q.toLowerCase().startsWith("select")) {
                return preparedStatement.executeQuery();
            } else {
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://160.153.49.168:3306/btcprogram?"
                            + "user=sully&password=asweq123e");
            if (!connection.isClosed()) {
                System.out.println("Successfully connected to the database...\nReady for SQL queries!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}