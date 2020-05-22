private boolean resultGridCreated = false;

@Override
public Grid grid() {
    if(!resultGridCreated) {
        createResultGrid("Test Grid");
        resultGridCreated = true;
    }
    return myGrid;
}