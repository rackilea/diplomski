POSModel model = new POSModelLoader().load(new File("en-pos-maxent.bin"));
    PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
    POSTaggerME tagger = new POSTaggerME(model);

    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\dell\\Desktop\\file2.txt"));

    BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\dell\\Desktop\\file.txt"));
    String line = "";
    while((line = bufferedReader.readLine()) != null){
        String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line);
        String[] tags = tagger.tag(whitespaceTokenizerLine);
        // Do your work with your tags and tokenized words


        bufferedWriter.write(/* the string which is needed to be written to your output */);
        // for adding new-lines in the output file, uncomment the following line:
        //bufferedWriter.newLine();
    }

    //Do not forget to flush() and close() the streams after your job is done:
    bufferedWriter.flush();
    bufferedWriter.close();
    bufferedReader.close();