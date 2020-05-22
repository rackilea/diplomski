String input="1001010101010101";
    int len=input.length();
    BitSet bs=new BitSet(len);
    int i=len-1;
    for (char c:input.toCharArray()) 
          bs.set(i--, c=='1'?true:false);