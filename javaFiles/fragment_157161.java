Tree treeObj = null;
Optional<Entry<String, Tree>> optional  = mapTreeRoot
        .children
        .entrySet().stream()
        .filter(map -> answer == map.getValue().numericPosition)
        .findAny();
if(optional.isPresent()){
    treeObj = optional.get().getValue();
}