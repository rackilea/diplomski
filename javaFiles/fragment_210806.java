IntWritable tmpInt;
for (Text val : values){
    tmpInt = (IntWritable) vector.get(val);

    if(tmpInt == null) {
        tmpInt = new IntWritable(0);
        // create a copy of val Text object
        vector.put(new Text(val), tmpInt);
    }

    // update the IntWritable wrapped int value
    tmpInt.set(tmpInt.get() + 1);

    // Note: you don't need to re-insert the IntWritable into the map
}