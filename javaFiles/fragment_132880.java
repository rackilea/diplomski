public Object getState() {
        SomeServiceState state = new SomeServiceState();
        state.setSomeData(someData);
        state.setSomeId(someId);
        state.setList(new ArrayList<>(list));
        if( collaborator instanceof HasState ) {
            state.getCollaboratorsState().add(collaborator.getState());
        }
        return state;
    }