@Override
public AClonable clone(){
    try {
        ByteArrayOutputStream outByte = new ByteArrayOutputStream();
        ObjectOutputStream outObj = new ObjectOutputStream(outByte);
        ByteArrayInputStream inByte;
        ObjectInputStream inObject;
        outObj.writeObject(this);
        outObj.close();
        byte[] buffer = outByte.toByteArray();
        inByte = new ByteArrayInputStream(buffer);
        inObject = new ObjectInputStream(inByte);
        @SuppressWarnings("unchecked")
        Object deepcopy =  inObject.readObject();
        inObject.close();
        return (AClonable) deepcopy;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}