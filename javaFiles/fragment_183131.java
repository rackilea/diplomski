public List<Action> getActionsFor(Actor a) {
    // this has to return a copy of the List or you will be modifying an original
    List<Action> theActions = super.getActionsFor(a);

    for (Action ac: a.getItemCarried().getActions()) {
        theActions.add(ac); // ac is an Action so all good.
    }

    return theActions;
}