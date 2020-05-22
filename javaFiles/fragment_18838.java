// never change this
private static final long serialVersionUID = 3375159358757648792L;
// only goes up
private static final int INTERNAL_VERSION_ID = 2;
...
// NOTE: in version #1, this was an int
private long paws;

private void readObject(java.io.ObjectInputStream in) {
    int version = in.readInt();
    switch (version) {
        case 1 :
            paws = in.readInt();
            ...
        case 2 :
            paws = in.readLong();
            ...

private void writeObject(java.io.ObjectOutputStream out) {
    out.writeInt(INTERNAL_VERSION_ID);
    out.writeLong(paws);
    ...