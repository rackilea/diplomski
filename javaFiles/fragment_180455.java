private void readObject(ObjectInputStream stream)
throws IOException,
       ClassNotFoundException {

    // First, do default serialization 
    stream.defaultReadObject();

    if (this.names == null) {
        this.names = new ArrayList<>();
    }
}