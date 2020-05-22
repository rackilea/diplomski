public static void main(String[] args) {        
        try {
            String url = "pass your url";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type",
                    "application/xml;charset=utf-8");
            String urlParameters = "<Request xmlns=\"abc\"><ID>1</ID><Password></Password></Request>";
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("response:" + response.toString());


            }
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());
        }
    }