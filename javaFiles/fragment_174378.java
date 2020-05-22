map(key, row, context){
  String filename= ((FileSplit)context.getInputSplit()).getPath().getName();
   if (filename.startsWith("datafile") {

     //split the review_id, words from row
     ....
     context.write(new Text("word), new Text("-1 | review_id"));

   } else if(filename.startsWith("term_index_file") {
     //split index and word
     ....
     context.write(new Text("word"), new Text("index | 0"));
   }

}