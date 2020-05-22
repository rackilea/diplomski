public void markInitialState (int initialStateId) {

        State theInitialState = allStates.get(initialStateId);
        theInitialState.isInitial=true;
        allStates.add(initialStateId, theInitialState);

        /*DEBUG*/

        System.out.println(" THE INITIAL STATE ID IS " + initialStateId);

        theInitialState = allStates.get(initialStateId);
        if ((theInitialState.isInitial)==true)
        System.out.println("THE STATE " + theInitialState + " IS MARKED AS INITIAL");

}