public List<FriendOfTarget> reduce() {
    return completeListOfFriendOfTargets
        .stream()
        .filter(this::reduceByThis)
        .collect(toList());
}