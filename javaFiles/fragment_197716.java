private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
    throw new java.io.NotSerializableException( getClass().getName() );
}

private void readObject(java.io.ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException {
    throw new java.io.NotSerializableException( getClass().getName() );
}