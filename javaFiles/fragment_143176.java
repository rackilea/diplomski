public void readFields(DataInput in) throws IOException {
    floatone = new FloatWritable();  
    floattwo = new FloatWritable(); 
    floatone.readFields(in);
    floattwo.readFields(in);
}