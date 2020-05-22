BufferedReader b = new BufferedReader(new FileInputStrem(file));

while(b.readLine() != null) {
     System.out.println(line.replace("=", "=(Long)"));
}

b.close();