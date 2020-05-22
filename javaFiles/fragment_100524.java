inputRdd.map(new Function<List<String>, String>() {
           @Override
           public String call(List<String> scores) throws Exception {
               int size = scores.size();
               StringBuffer sb = new StringBuffer();
               for (int i=0; i <size;i++){
                   sb.append(scores.get(i));
                   if(i!=size-1){
                        sb.append("\n");
                    }
               }
               return sb.toString();
           }
       }).saveAsTextFile("/tmp/data"));