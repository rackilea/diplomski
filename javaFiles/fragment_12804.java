int red = -1;
byte[] buffer = new byte[5*1024]; // a read buffer of 5KiB
byte[] redData;
StringBuilder clientData = new StringBuilder();
String redDataText;
while ((red = clientSocket.getInputStream().read(buffer)) > -1) {
    redData = new byte[red];
    System.arraycopy(buffer, 0, redData, 0, red);
    redDataText = new String(redData,"UTF-8"); // assumption that client sends data UTF-8 encoded
    System.out.println("message part recieved:" + redDataText); 
    clientData.append(redDataText);
}
System.out.println("Data From Client :" + clientData.toString());