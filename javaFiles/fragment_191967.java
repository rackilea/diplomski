URL url=new URL("http://msyserver/abc/servlet1");
URLConnection con=url.openConnection();
con.setDoOutput(true);
con.setDoInput(true);
con.getExpiration();//<----------
OutputStream os=con.getOutputStream();
ObjectOutputStream oos=new ObjectOutputStream(os);
oos.writeObject(pushEmailDTO);
oos.flush();
oos.close();