public <A extends Action> List<A> getActionsFor(Actor<A> a) {
    List<A> theActions = super.getActionsFor(a);

    for (A ac: a.getItemCarried().getActions()) {
        theActions.add(ac); // ac is an A, so all good.
    }

    return theActions;
}