public void writeSparseArray(Parcel dest, SparseArray<int[]> sparseArray) {
    if (sparseArray == null) {
        dest.writeInt(-1);
        return;
    }
    int size = sparseArray.size();
    dest.writeInt(size);
    int i=0;
    while (i < size) {
        dest.writeInt(sparseArray.keyAt(i));
        dest.writeIntArray(sparseArray.valueAt(i));
        i++;
    }
}

private SparseArray<int[]> readSparseArrayFromParcel(Parcel source){
    int size = source.readInt();
    if (size < 0) {
        return null;
    }
    SparseArray sa = new SparseArray(size);
    while (size > 0) {
        int key = source.readInt();
        int[] value = source.createIntArray();
        sa.put(key, value);
        size--;
    }
    return sa;
}