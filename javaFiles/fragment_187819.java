private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
    Iterator itr = testSet.iterator();
    if (testSet.getClass().equals(TM_KS_CLASS)) {
        stream.writeBoolean(true);
    } else {
        stream.writeBoolean(false);
    }
    stream.writeInt(testSet.size());
    while(itr.hasNext()) {
        stream.writeObject(itr.next());
    }
    stream.writeObject(justSomeOtherFieldToSerialize);
}