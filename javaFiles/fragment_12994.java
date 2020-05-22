public static String sendFirst(String requestString) throws Exception {
        BufferedReader in = null;
        try {
            HttpClient client = getHttpClient();
            HttpPost request = new HttpPost(universal_URL_MENU+"?request_menu="+start_menu);


            HttpResponse response = client.execute(request); 
            System.out.println("response in class"+response);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();

             result = sb.toString();
   //     }
        }catch(Exception e){
            e.printStackTrace();  
            System.out.println("catch");  
        }

        finally {
            if (in != null) {  
                try {
                    in.close();   
                } catch (IOException e) {   
                    e.printStackTrace();    
                }
            }
        }
        return result;    
    }