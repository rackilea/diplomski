for(int j=0;j<Index.size();j++){
   for(int y=0;y<Index.get(j).getEggrafi().size();y++){
     if((Index.get(j).getEggrafi().get(y).getWord()).equals(tokens[i-1])){
        Index.get(j).getEggrafi().add(new Page(fileName[k],byte_count));
     }
     else{
      Index.add(new IndPage(fileName[k],byte_count));
    }
  }
}