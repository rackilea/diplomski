Scanner s = new Scanner(new File("filepath"));
ArrayList<String> list = new ArrayList<String>();
while (s.hasNext()){
    list.add(s.next());
}
s.close();