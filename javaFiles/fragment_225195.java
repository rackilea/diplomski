public static String simSearchByImg(File file,int  catid ,String subject,String labeland,String labelor,String labelnot) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result =null;
        try {
            HttpPost httppost = new HttpPost("http://api0.visualsearchapi.com:8084/vsearchtech/api/v1.0/apisim_search");

            FileBody bin = new FileBody(file);
            StringBody catidBody = new StringBody(catid+"" , ContentType.TEXT_PLAIN);
            StringBody keyBody = new StringBody(APPKEY , ContentType.TEXT_PLAIN);
            StringBody langBody = new StringBody(LANG , ContentType.TEXT_PLAIN);
            StringBody fmtBody = new StringBody(FMT , ContentType.TEXT_PLAIN);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addPart("apikey", keyBody)
            .addPart("photo", bin)
            .addPart("catid", catidBody)
            .addPart("lang", langBody)
            .addPart("fmt", fmtBody);
            if(subject != null && subject.isEmpty() == false){
                 StringBody subjectBody = new StringBody(subject, Charset.forName("UTF-8"));
                 builder.addPart("subject", subjectBody);
            } 
            if(labeland != null && labeland.isEmpty() == false){
                 StringBody labelandBody = new StringBody(labeland , ContentType.TEXT_PLAIN);
                 builder .addPart("labeland", labelandBody);
            }
            if(labelor != null && labelor.isEmpty() == false){
                 StringBody labelorBody = new StringBody(labelor , ContentType.TEXT_PLAIN);
                 builder .addPart("labelor", labelorBody);
            }
            if(labelnot != null && labelnot.isEmpty() == false){
                 StringBody labelnotBody = new StringBody(labelnot , ContentType.TEXT_PLAIN);
                 builder .addPart("labelnot", labelnotBody);
            }
            HttpEntity reqEntity =  builder.build();
            httppost.setEntity(reqEntity);
            response = httpClient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
               // result = ConvertStreamToString(resEntity.getContent(), "UTF-8");
                String charset = "UTF-8";   
                String content=EntityUtils.toString(response.getEntity(), charset);   
                System.out.println(content);
            }
            EntityUtils.consume(resEntity);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            response.close();
            httpClient.close();
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            simSearchByImg(new File("/path/dog1.jpg"),0,null,null,null,null);
            /*Above Java request upload an image /path/dog1.jpg, search for 
            visually similar images,by using your apikey, values of other parameters 
            are as default*/
            simSearchByImg(new File("/path/dog1.jpg"),45,"pet","345,356",null,"98")
            /*Above Java request upload an image dog1.jpg, search for visually similar 
            images, by using your apikey, search for similar images with keyword “pet”, 
            image category as 45, and result images have labels 345 and 356, 
            but without label 98.  Values of other parameters are as default*/   
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}