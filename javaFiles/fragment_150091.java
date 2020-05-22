ArrayList<Integer> foo = new ArrayList<Integer>();
    foo.add(5);
    foo.add(3);
    foo.add(1);
    ArrayList<Integer> obj = null;
    // Write the object out to a byte array
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(bos);
    out.writeObject(foo);
    out.flush();
    out.close();

    // Make an input stream from the byte array and read
    // a copy of the object back in.
    ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
            bos.toByteArray()));
    obj = (ArrayList<Integer>)in.readObject();