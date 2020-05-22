ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>(); 

// This won't work, but imagine that it did...
List<List<Integer>> lists = arrayLists;

// This is fine - a LinkedList<Integer> is a List<Integer>
lists.add(new LinkedList<Integer>());

// This should be fine too
ArrayList<Integer> arrayList = arrayLists.get(0);