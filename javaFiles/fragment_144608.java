public static MyClass create(byte[] input) {
    try(ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(input))) {
        return (MyClass)in.readObject();
    }
    catch (Exception e) {
        throw new IllegalStateException("could not create object", e);
    }
}