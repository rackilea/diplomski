public static String btcvalue(){
        String msg = "";
        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/bitcoin/?convert=CAD");
            System.setProperty("http.agent", "Chrome");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) {
                msg = msg + str;
            }
            String decodedText = msg;
            String[] parts = decodedText.split("price_cad");
            String[] amnt = parts[1].split(",");
            String[] finn = amnt[0].split(":");
            msg = finn[1].replace("\"", "");
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "10.000";
        }
        return msg;
    }