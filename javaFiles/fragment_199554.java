private YourClass newInstance(byte[] bytes){
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    ObjectInput in = null;
    YourClass o = null;
    try {
        in = new ObjectInputStream(bis);
        o = (YourClass)in.readObject();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (ClassCastException e){
        e.printStackTrace();
    }finally {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            // ignore close exception
        }
    }
    return o;
}

private byte[] toBytes(YourClass object){
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutput out = null;
    byte[] bytes = new byte[1];
    try {
        out = new ObjectOutputStream(bos);

        object.setTimestamp(System.currentTimeMillis());

        out.writeObject(object);
        out.flush();
        bytes = bos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            bos.close();
        } catch (IOException ex) {
            // ignore close exception
        }
    }
    return bytes;
}