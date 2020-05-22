List<byte[]> list = new ArrayList<byte[]>();
    list.add("HI".getBytes());
    list.add("BYE".getBytes());

    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
            "test.txt"));
    out.writeObject(list);

    ObjectInputStream in = new ObjectInputStream(new FileInputStream(
            "test.txt"));
    List<byte[]> byteList = (List<byte[]>) in.readObject();

    //if you want to add to list you will need to add to byteList and write it again
    for (byte[] bytes : byteList) {
        System.out.println(new String(bytes));
    }