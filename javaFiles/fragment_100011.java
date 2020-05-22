if (node.item == null) {
    oos.writeByte(0);
} else {
    oos.writeByte(1);
    oos.writeObject(note.item);
}

// to read
Item item = ois.readByte() == 0 ? null : (Item) ois.readObject();