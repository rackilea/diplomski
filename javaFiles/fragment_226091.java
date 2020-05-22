HashSet<MyObject> set1 = new HashSet<MyObject>(array1);
HashSet<MyObject> set2 = new HashSet<MyObject>(array2);

Set<MyObject> intersection = new HashSet<MyObject>(set1);
intersection.retainAll(set2);

if(intersection.size() == set2.size()) { 
    // They're the same.
} else { 
    HashSet<MyObject> itemsOnlyInSet1 = intersection;
    HashSet<MyObject> itemsOnlyInSet2 = set2.retainAll(set1);
}