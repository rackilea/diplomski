Scanner fileIn = new Scanner(new File("words.txt"));
List<String> list = new ArrayList<>();
while (fileIn.hasNext()) {
    list.add(fileIn.next());
}           
Collections.sort(list);
int pos = 0;
while (pos != list.size()) {
    int next = pos+1;
    while (next != list.size() && list.get(pos).equals(list.get(next))) {
        next++;
    }
    if (next == pos+1) {
        System.out.println(list.get(pos));
    }
    pos = next;
}