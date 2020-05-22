ArrayList<Integer> list = new ArrayList<Integer>();
list.add(2);
list.add(-1);
list.add(4);
ArrayList<Integer> it = new ArrayList<Integer>();
final int initial_size = list.size();
for(int i = 0;i<initial_size;i++) {
    Integer maxo = Collections.max(list);
    it.add(maxo);
    list.remove(maxo);
}
System.out.println(it);