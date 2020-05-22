BufferedReader in = new BufferedReader(new FileReader(file));
List<String> myNicknames = new ArrayList<String>();
String line;

while ( (line = in.readLine()) != null) {
   myNicknames.add(line);
}
in.close();

System.out.println(myNicknames.get( (int)(Math.random() * myNicknames.size()) ));