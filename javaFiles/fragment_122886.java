public static void main(String args[]) {
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> newReference;
    list.add("String1");
    list.add("String2");
    list.add("String3");
    newReference = list;
    newReference.remove(0); // This will remove the item in the first index of the object. This will remove from both list and newReference as they are currently referencing the same object.
    newReference = list.clone();
    newReference.remove(0); // This will remove the item in the first index of the object referenced by newReference. It is not the same as that of list as you have cloned the data to a new segment of memory.
}