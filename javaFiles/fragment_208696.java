List<Item> list = new ArrayList<>();

    list.add(new Item("A", "2006"));
    list.add(new Item("B", "2016"));


    // Serialize
    FileOutputStream fos = context.openFileOutput("list.ser", Context.MODE_PRIVATE);
    ObjectOutputStream os = new ObjectOutputStream(fos);
    os.writeObject(list);
    os.close();
    fos.close();


    // Deserialize

    FileInputStream fileIn = context.openFileInput("list.ser");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    list = (List<Item>) in.readObject();
    in.close();
    fileIn.close();

    // Implement toString() in Item
    System.out.println(list);