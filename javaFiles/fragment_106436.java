public void load() {
    SerializableObject originalObject = new SerializableObject(new Vector<int[]>(), new Vector<int[]>(), 10, 10, 200);
    // Here you can do something with the newly created object, such as save it to a file.

    SerializableObject deserializedObject = fileChooser.load();
    System.out.println(deserializedObject + " LAST");
}