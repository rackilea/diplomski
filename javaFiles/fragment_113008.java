ResponseHandler<String> responseHandler = new BasicResponseHandler();
                        String response = httprespons.execute(httpentity, responseHandler);
        try {  
            HttpEntity entity = response.getEntity();

                           StringBuffer out = new StringBuffer();
                           byte[] b = EntityUtils.toByteArray(entity);

                           out.append(new String(b, 0, b.length));
                           return out.toString();

        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } ;