for (Text val : values){
    if(vector.containsKey(val)){
        vector.put(val , new IntWritable(((IntWritable)vector.get(val)).get() + 1));
    }
    else
        vector.put(val , new IntWritable(1));
}