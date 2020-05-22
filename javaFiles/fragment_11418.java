Map<Character,Integer> map = new HashMap<Character, Integer>();
map.put('a',1);
map.put('c',10);
map.put('p',5);
map.put('2',7);
PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>(map.size(), new Comparator<Entry<Character, Integer>>() {

    @Override
    public int compare(Entry<Character, Integer> arg0,
            Entry<Character, Integer> arg1) {
        return arg0.getValue().compareTo(arg1.getValue());
    }
});
pq.addAll(map.entrySet());
while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}