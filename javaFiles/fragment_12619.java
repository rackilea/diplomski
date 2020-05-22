final String name = findTextField(c).getText();
final String qty = findTextField1(c).getText();

ConnectionRequest r= new ConnectionRequest(){    
        @Override
        protected void buildRequestBody(OutputStream os) throws IOException {
            StringBuilder val = new StringBuilder("{\"name\":\"");
            val.append(name);
            val.append("\",\"quantity\":");
            val.append(qty);
            val.append("}");
            if(shouldWriteUTFAsGetBytes()) {
                os.write(val.toString().getBytes("UTF-8"));
            } else {
                OutputStreamWriter w = new OutputStreamWriter(os, "UTF-8");
                w.write(val.toString());
            }                                  
        }
        @Override
        protected void readResponse(InputStream input) throws IOException {                              
        }                  
       };    
   r.setUrl("http://localhost:8080/webservicess/webresources/getreq/post");
   r.setPost(true);
   NetworkManager.getInstance().addToQueueAndWait(r);