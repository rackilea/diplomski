for(String symbol : symbols) {
      while(s.indexOf(symbol) >= 0){
        index = s.indexOf(symbol);
        //
        s = s.substring(0,index)+s.substring(index+1,index+2).toUpperCase()+s.substring(index+2);
        //
        System.out.println(s);
      }
    }