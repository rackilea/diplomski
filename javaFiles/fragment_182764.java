client = new Socket(serverIPString,Integer.parseInt(serverPortString));
InputStream in = client.getInputStream();
OutputStream out = client.getOutPutStream();

//Do your work with input and output stream.....

in.close();
out.close();