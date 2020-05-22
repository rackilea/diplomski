public void map(Object key, Text value, Context context) {
    String[] linha = value.toString().split(";");       
    cidadeproduto.set(linha[2] + "&" + linha[3]);
    context.write(cidadeproduto, new IntWritable(1));       
}

public void reduce(Text key, Iterable<IntWritable> values, Context context){
    int contValue = 0;

    for (IntWritable value : values) {
        contValue += value.get();
    }
    context.write(key, new IntWritable(contValue));
}