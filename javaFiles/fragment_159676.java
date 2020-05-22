public interface Externalizer<T> {
    void write(T object, ObjectOutput out);
    void read(T object, ObjectInput in);
}

class TrieExternalizer implements Externalizer<Trie> {
    public void write(Trie object, ObjectOutput out) throws IOException {
        out.writeUTF(object.getSomeField());
    }


    public void read(Trie object, ObjectInput in) throws IOException {
        object.setSomeField(in.readUTF());
    }
}

class Trie implements Externalizable {
    private String someField;
    private static final Externalizer<Trie> externalizer = new TrieExternalizer();

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        externalizer.write(this, out);
    }

    public void readExternal(ObjectInput in) throws IOException {
        externalizer.read(this, in);
    }
}