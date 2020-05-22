public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

    // We use this to get the String representation of the Text data type which is 
    // more suitable for distributed processing.
    String line = value.toString();

    // A tokenizer tokenizes (or divides) a sentence into individual words. It is 
    // deprecated though (not used anymore), so we should use line.split()
    // String[] tokens = line.split();
    StringTokenizer tokenizer = new StringTokenizer(line);

    // The tokenizer gives out a boolean (true or false) based on whether it has 
    // more tokens (words) or not. If split() is used, we can use a for loop.
    // for (String token : tokens) {
    //    word.set(token);
    while (tokenizer.hasMoreTokens()) {
        // I am guessing word is of Text type. Since like I previously said, Text 
        // data type is more suitable for distributed computing, we are converting 
        // the String token we have into text type. We have to define the word 
        // variable somewhere though.
        // If split() is used, we can write word.set(token);
        word.set(tokenizer.nextToken());
    }

    // Context is something which lets you pass key-value pairs forward. Once you 
    // write them using a Context object, the shuffle is performed and after the 
    // shuffle, they are grouped by key and each key along with its values is 
    // passed to the reducer.
    context.write(word, one);
}