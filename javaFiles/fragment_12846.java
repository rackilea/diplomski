class Producer {

    private volatile StateObj stateRef;

    StateObj getRef() {
        return stateRef;
    }

    void modify() {
        // Leave the instance field alone until modification is done
        StateObj newObj = (StateObj) stateRef.clone();
        // Do stuff to the new local variable reference. If any consumers
        // call getRef while this is happening they get the stateRef value and
        // not the newObj value.

        // Once the newObj instance if fully initialized, set it as
        // the stateRef instance.
        stateRef = newObj;
    }
}