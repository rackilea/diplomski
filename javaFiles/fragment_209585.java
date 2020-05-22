class NonSerializableResponseException extends Exception {}

class ServiceResponseWrapper implements DataSerializable {

    private Object response;

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        try {
            out.writeObject(response);
        } catch (HazelcastSerializationException e) {
            out.writeObject(new NonSerializableResponseException());
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        response = in.readObject();
    }
}