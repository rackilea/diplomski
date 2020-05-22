public EnumSet<Action> getAllowedActions() {
    return EnumSet.of(Action.ACTION1, Action.ACTION2);
}

...
if (getAllowedAction().contains(Action.ACTION1)) {
    ...
}