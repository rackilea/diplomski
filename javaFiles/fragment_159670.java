if (maxCount < counter) {
    leader = name;
    maxCount = counter;
} else if(maxCount == counter && name.compareTo(leader) < 0) {
    // same number of distinct character => lexicographical ordering
    leader = name;
    maxCount = counter;
}