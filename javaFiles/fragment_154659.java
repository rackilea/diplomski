try {
            StringEntity se = new StringEntity(sendData);
            httppost.setEntity(se);
            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            System.out.println("Message Sent!");
            inputStreamToString(response.getEntity().getContent());
            }