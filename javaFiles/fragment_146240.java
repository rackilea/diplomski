//If a key doesn't exist in a hashmap, `get(T)` returns null
if(DayCount.get(str) == null) {
    //We know this key doesn't exist, so let's create a new entry with 1 as the count
    DayCount.put(str, 1);
} else {
    //We know this key exists, so let's get the old count, increment it, and then update
    //the value
    int count = DayCount.get(str);
    DayCount.put(str, count + 1);
}