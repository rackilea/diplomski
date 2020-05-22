Collection<Integer> values = hashmap.values(); // get values
List<Integer> listVal = new ArrayList<Integer>(values); 
Collections.sort(listVal, new Comparator<Integer>() { // sort in decreasing order 
    public int compare(Integer o1, Integer o2) {
        return - o1.compareTo(o2); 
    }
});

Integer maxVal = listVal.get(0); // get first (max value)

Collection<Character> returns = new ArrayList<Character>(); 

for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
    if (entry.getValue().intValue() == maxVal.intValue()) { 
        returns.add(entry.getKey());  // get all keys that matches maxVal
    }
}

return returns;