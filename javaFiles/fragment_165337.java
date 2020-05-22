BufferedReader reader = new BufferedReader(new FileReader("/path/to/file.txt"));
CustomList list = new CustomList();//not sure what your list is called
String line = null;
while ((line = reader.readLine()) != null) {
    list.add(new CustomeNode(line));
}