String keyword="summarization";
    StringTokenizer tokenizer =new StringTokenizer(text,"\\.") ;

     while(tokenizer.hasMoreTokens())
     {
             String x= tokenizer.nextToken();

              for(final String s :x.split(" ")){

               if(keyword.equals(s))
               {
                    System.out.println(x);
               } 
            }
     }