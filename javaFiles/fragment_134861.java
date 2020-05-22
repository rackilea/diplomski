public static class TheObject implements Serializable {
    private int id;
    private transient Image img; // not written to stream via default serialisation

    TheObject(int id, Image img) {
      this.id = id;
      this.img = img;
    }

    ...

    // custom serialisation
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // write non-transient data

        // write image if not null
        out.writeBoolean(img != null);
        if (img != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", out);
        }
    }

    // custom deserialisation
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // read non-transient data
        in.defaultReadObject();

        // read image if not null
        if (in.readBoolean()) {
            img = new Image(in);
        } else {
            img = null;
        }
    }
}