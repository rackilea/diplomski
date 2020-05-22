final HashMap<String, ButtonMemento> mapButton = new HashMap<>();

for(Button b : buttons){
    String mapKey = ...;
    mapButton.put(mapKey, new ButtonMemento(b));
}    

try {
    FileOutputStream fileOut = new FileOutputStream("Resources/");
    ObjectOutputStream objStream = new ObjectOutputStream(fileOut);
    objStream.writeObject(mapButton);
    objStream.close();
    fileOut.close();
    System.out.println("Serialized HashMap mapButtons has been stored"
                     + " in /tmp/store");
} catch (IOException i) {
      i.printStackTrace();
}