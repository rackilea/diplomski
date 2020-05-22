br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String temp;
while ((temp=br.readLine())!=null) { //check null reference
    if (temp.length() == 0)
        Thread.sleep(100);
    else
        System.out.println(" Receiving from server: " + temp);
}