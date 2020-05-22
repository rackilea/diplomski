static class DataHolder {
    int i1;
    int i2;
    int i3;
    DataHolder d1;
    DataHolder d2;
    public DataHolder(int i1, int i2, int i3, DataHolder dh) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.d1 = dh;
        this.d2 = this;
    }
}

Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
theUnsafe.setAccessible(true);
Unsafe unsafe = (Unsafe) theUnsafe.get(null);

DataHolder dh1 = new DataHolder(11, 13, 17, null);
DataHolder dh2 = new DataHolder(23, 29, 31, dh1);