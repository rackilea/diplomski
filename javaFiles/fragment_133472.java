StringBuffer buffer = new StringBuffer();
String line;
String userFile = file + ".txt";

BufferedReader in = new BufferedReader(new FileReader(userFile));
while ((line = in.readLine()) != null) {
   buffer.append(line); //error here
}

byte[] bytes = buffer.toString().getBytes();