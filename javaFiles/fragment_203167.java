private static volatile String[][] stateList;
...

public State[] getStateList() {
    if (stateList[country] == null) {
        synchronized (this) {
            if (stateList[country] == null) {
                // Do network request FetchStatesTask and then return State[] after async operation
            }
        }
    }
    return stateList[country];
}