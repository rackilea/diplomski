class MultipartUtility {
    public HttpURLConnection httpConn;
    public OutputStream request;//if you wanna send anything out of ordinary use this;
    private final String boundary =  "*****";//alter this as you wish
    private final String crlf = "\r\n";
    private final String twoHyphens = "--";
    public MultipartUtility(String requestURL)
            throws IOException {
        URL url = new URL(requestURL);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        httpConn.setRequestMethod("POST");
        //alter this part if you wanna set any headers or something
        httpConn.setRequestProperty("Connection", "Keep-Alive");
        httpConn.setRequestProperty("Cache-Control", "no-cache");
        httpConn.setRequestProperty(
                "Content-Type", "multipart/form-data;boundary=" + this.boundary);
        request = httpConn.getOutputStream();
    }
    //or add some other constructor to better fit your needs; like set cookies and stuff
    public void addFormField(String name, String value)throws IOException {
        request.write(( this.twoHyphens + this.boundary + this.crlf).getBytes());
        request.write(("Content-Disposition: form-data; name=\"" + name + "\""+ this.crlf).getBytes());
        request.write(this.crlf.getBytes());
        request.write((value).getBytes());
        request.write(this.crlf.getBytes());
        request.flush();
    }
    public void addFilePart(String fieldName, File uploadFile)
            throws IOException,Exception {
        if(uploadFile.isDirectory())throw new Exception("for real? what do you expect to happen?");
        request.write((this.twoHyphens + this.boundary + this.crlf).getBytes());
        request.write(("Content-Disposition: form-data; name=\"" +
                fieldName + "\";filename=\"" +
                uploadFile.getName()+ "\"" + this.crlf).getBytes());
        request.write(this.crlf.getBytes());
        InputStream is=new FileInputStream(uploadFile);
        byte[] bytes = new byte[1024];
        int c=is.read(bytes);
        while(c>0){
            request.write(bytes,0,c);
            c=is.read(bytes);
        }
        request.write(this.crlf.getBytes());
        request.flush();
        is.close();
    }
    public String finish() throws IOException {
        String response ="";
        request.write((this.twoHyphens + this.boundary +
                this.twoHyphens + this.crlf).getBytes());
        request.flush();
        request.close();
        int status = httpConn.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = httpConn.getInputStream();
            byte[] b=new byte[1024];
            int c=responseStream.read(b);
            while(c>0){
                response=response+new String(b,0,c);
                c=responseStream.read(b);
            }
            responseStream.close();
        } else {
            httpConn.disconnect();
            throw new IOException("Server returned non-OK status: " + status);
        }
        httpConn.disconnect();
        return response;
    }
    public InputStream finish_with_inputstream()throws Exception{
        request.write((this.twoHyphens + this.boundary +
                this.twoHyphens + this.crlf).getBytes());
        request.flush();
        request.close();
        int status = httpConn.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            return httpConn.getInputStream();
        } else {
            throw new IOException("Server returned non-OK status: " + status);
        }
    }
}