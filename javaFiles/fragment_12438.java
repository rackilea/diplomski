class MyObject {

    private static int counter = 0;

    public final int objectId;

    MyObject() {
        this.objectId = counter++;
    }
}