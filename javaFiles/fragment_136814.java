public class FileGroupDescriptor extends Structure {
    public int cItems;
    public FileDescriptor[] fgd;

    public FileGroupDescriptor(Pointer pointer) {
        super(pointer);
        this.cItems = pointer.readInt(0);
        this.fgd = new FileDescriptor[this.cItems];
        this.read();
    }
}