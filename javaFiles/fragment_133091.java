URL url = new URL(host);
            urlConnection = (HttpURLConnection) url.openConnection();

            int code = urlConnection.getResponseCode();
            System.out.print(code);
            if(code==200){
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                StringWriter writer = new StringWriter();

                if (in != null) {


                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                        String line = "";

                        while ((line = bufferedReader.readLine()) != null)
                            result += line;


                    result = result.substring(1);
                    JSONParser jsonParser = new JSONParser();
                    JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
                    result=(String) jsonObject.get("name");
                    System.out.print(jsonObject);
                }
                in.close();
}