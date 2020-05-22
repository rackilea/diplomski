for(Integer i : list) {                
    if (treeSet.size() < 10) {                    
        treeSet.add(i);
    } else if (i > treeSet.first()) {
        treeSet.pollFirst();
        treeSet.add(i);
    }
}