SequenceFile.Reader read = new SequenceFile.Reader(fs, new Path("<path do dictionary>"), conf);
        IntWritable dicKey = new IntWritable();
        Text text = new Text();
        Map<Integer, String> dictionaryMap = new HashMap();
        while (read.next(text, dicKey)) {
            dictionaryMap.put(Integer.parseInt(dicKey.toString()), text.toString());
        }
        read.close();