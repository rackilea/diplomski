...
httpCon.setRequestMethod("POST");
httpCon.connect(); // Note the connect() here
...
OutputStream os = httpCon.getOutputStream();
OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
...    
osw.write(msg.toString());
osw.flush();
osw.close();