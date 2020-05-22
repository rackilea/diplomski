public static class PairWritable implements Writable 
{
   private Double myDouble;
   private String myString;

    // TODO :-  Override the Hadoop serialization/Writable interface methods
    @Override
    public void readFields(DataInput in) throws IOException {
            myLong = in.readDouble();
            myString = in.readUTF();
    }

    @Override
    public void write(DataOutput out) throws IOException {
            out.writeDouble(myLong);
            out.writeUTF(myString);
    }

    //End of Implementation

    //Getter and Setter methods for myLong and mySring variables
    public void set(Double d, String s) {
        myDouble = d;
        myString = s;
    }

    public Long getLong() {
        return myDouble;
    }
    public String getString() {
        return myString;
    }

}