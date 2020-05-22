Set<Integer> myInts = new HashSet<Integer>();
for(Entry<Integer, String> entry : foo.entrySet()) { // go through the entries
    if(entry.getValue().equals("abc")) {             // check the value
        myInts.add(entry.getKey());                  // add the key
    }
}
// myInts now contains all the keys for which the value equals "abc"