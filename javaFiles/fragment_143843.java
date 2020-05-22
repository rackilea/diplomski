private boolean isAddOrNa(List<AllActions> allActions) {
    Set<String> actions = new HashSet<>();
    for (com.demo.Action action : allActions) {
        actions.add(action.getName());
    }
    return actions.contains("ADD") && ((actions.contains("NA") && actions.size() ==2) || (!actions.contains("NA") && actions.size() ==1));
}