DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"));
StringBuffer inputLine = new StringBuffer();
String tmp;
while ((tmp = dis.readLine()) != null) {
     inputLine.append(tmp);
     System.out.println(tmp);
}
dis.close();