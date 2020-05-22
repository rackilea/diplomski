public static class TokenizerMapper extends
        Mapper<Object, Text, Text, Text> {
    private Text word1 = new Text();
    private Text word2 = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        StringTokenizer itr = new StringTokenizer(line,",");
        if(itr.hasMoreElements()){
         word1.set(itr.nextToken().toLowerCase());

        }
        if(itr.hasMoreElements()){
            word2.set(itr.nextToken().toLowerCase());

        }
        context.write(word1, word2);
        context.write(word2, word1);