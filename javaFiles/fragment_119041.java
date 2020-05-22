BufferedReader abc = new BufferedReader(new FileReader(myfile));
List<String> lines = new ArrayList<String>();

while((String line = abc.readLine()) != null) {
    lines.add(line);
    System.out.println(data);
}
abc.close();

// If you want to convert to a String[]
String[] data = lines.toArray(new String[]{});