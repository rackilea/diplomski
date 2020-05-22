MyObject value = null;
try {
    try (ObjectInputStream is = new ObjectInputStream(
      getClass().getClassLoader().getResourceAsStream("data/hm_pj.data"); 
    ))) {
        value = (MyObject) is.readObject();
    }
} catch (IOException | ClassNotFoundException e) {
    System.out.println("Error: " + e);
}
return value;