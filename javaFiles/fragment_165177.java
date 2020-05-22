private final static IntWritable ONE = new IntWritable(1); 
private final static IntWritable NEG_ONE = new IntWritable(-1); 

...

    IntWritable status;
    if (companyResponseToConsumer.toLowerCase().contains(lookfor)) {status=NEG_ONE;}
    else {status=ONE;}

    if (!companyName.isEmpty())
    {
        word.set (companyName);
        context.write(companyName, status); 
    }