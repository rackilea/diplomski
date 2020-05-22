public void writeExternal(ObjectOutput out) throws IOException {        
    out.writeObject(super.toArray());
    out.writeObject(field1);
    out.writeObject(field2);
}

public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {
    Object[] arr = (Object[]) in.readObject();
    for (int k=0; k<arr.length; k++) super.add(arr[k]);
    field1 = (Field) in.readObject();
    field2 = (Field) in.readObject();
}