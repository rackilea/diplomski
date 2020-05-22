List <String> file1Words = Arrays.asList(words);
     List <String> file2Words = Arrays.asList(list);

     for(String s : file1Words)
        if(!file2Words.contains(s))
          System.out.println(s);