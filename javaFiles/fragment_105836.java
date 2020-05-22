//If all the elements would be removed, use sublist to get every element but last one
//Clear sublist
if(items.stream().allMatch(e -> condition(e))) {
    items.subList(0, items.size() -1).clear();
} else {
    //else it is safe to directly call removeIf()
    items.removeIf(e -> condition(e));
}