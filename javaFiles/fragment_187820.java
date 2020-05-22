private void readObject(java.io.ObjectInputStream stream) throws java.io.IOException {
    boolean bTypeofmap = stream.readBoolean(); // Whether its a TreeMap or LinkedhashMap
    int size = stream.readInt();
    testSet = new java.util.HashSet(size);
    for(int i = 0; i < size; i++) {
        testSet.add(stream.readObject());
    }
    justSomeOtherFieldToSerialize = (String) stream.readObject();
}