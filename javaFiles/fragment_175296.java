String string = "(product(version(id),code),use)r(uid)";
StringBuilder sb = new StringBuilder();
    int countOpenPar = 0;
    for (int i=0; i<string.length(); i++) {
      char c = string.charAt(i);

      if( c == '(' ){
        countOpenPar++;
      }else if( c == ')' ){
        countOpenPar-- ;
      }else if( countOpenPar == 0){
        sb.append(c);
      }
    }
    System.out.println("string= " + sb.toString());