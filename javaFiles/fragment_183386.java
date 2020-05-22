private SharedSpace sharedSpace;

public Producer(SharedSpace sharedSpace) {
    super();
    this.sharedSpace = sharedSpace;
}

public SharedSpace getSharedSpace() {
    return sharedSpace;
}

public void setSharedSpace(SharedSpace sharedSpace) {
    this.sharedSpace = sharedSpace;
}

@Override
public void run() {

    for(int i=0;i<3;i++)
    {
        int value = (int) (Math.random()*30);
        sharedSpace.addValue(value);
    }


}