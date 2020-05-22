try (FileInputStream fi = new FileInputStream(f); 
    ObjectInputStream reader = new ObjectInputStream(fi)) {        

    while (true) {
        Item i = (Item)reader.readObject();
        System.out.println(i.getName());
    }

} catch (Exception e) {
    System.out.println(e.toString());
}