try{
        MultipartUtility m=new MultipartUtility("https://mydomain");//now add you different data parts;
        m.addFilePart("file_part",new File("some_file_location"));
        m.addFormField("value_name","value");
        //call either of the below methods based on what you need; do not call both!
        String result=m.finish();//call this if the response is a small text 
        InputStream is=m.finish_with_inputstream(); //call this if the response is huge and not fitting in memory; don't forget to disconnect the connection afterwards;
    } catch (IOException e) {
        e.printStackTrace();
    }