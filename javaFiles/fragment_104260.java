public List<FriendOfTarget> reduce() {
    return completeListOfFriendOfTargets
        .stream()
        .filter(fot -> fot.reduceOtherDirection(this))
        .collect(toList());
}