public class TextWritable implements Writable {

    private Set<Text> values;

    public TextPair() {
        values = new HashSet<Text>();
    }

    @Override
    public void write(DataOutput out) throws IOException {

        // Write out the size of the Set
        out.writeInt(valueSet.size());

        // Write out each Text object
        for(Text t : values) {
            t.write(out);
        }
    }

    @Override
    public void readFields(DataInput in) throws IOException {

        // Make sure we have a HashSet to fill up
        values = new HashSet<Text>();

        // Get the number of elements in the set
        int size = in.readInt();

        // Read the correct number of Text objects
        for(int i=0; i<size; i++) {
            Text t = new Text();
            t.readFields(in);
            values.add(t);
        }
    }
}