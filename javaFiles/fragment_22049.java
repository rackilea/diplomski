String unitIdList = // ...
Set<String> distinctIds = new HashSet<>(Arrays.asList(unitIdList.split(";")));
if(distinctIds.size() == 1) {
    // all the same ids
} else {
    // not all the same!
}