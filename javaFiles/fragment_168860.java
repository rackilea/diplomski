try{
        MultipartUtility m=new MultipartUtility("https://mydomain");
        m.addFilePart("bill",new File(sourceFile));
        m.addFormField(URLEncoder.encode("username" , "UTF-8"),URLEncoder.encode(username,"UTF-8"));
        String result=m.finish();
    } catch (Exception e) {
        e.printStackTrace();
    }