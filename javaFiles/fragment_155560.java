class MyBitSet extends BitSet{

    public MyBitSet(String bits) throws IllegalArgumentException
    {
          super(bits.length());
          for(int i = 0; i < bits.length(); i++){
            if(bits.charAt(i) > '1' || bits.charAt(i) < '0') {
               throw new IllegalArgumentException("Wrong bit!");
            }
            if(bits.charAt(i) == '1'){
               this.flip(bits.length() - 1 - i);
            }

          }
    }

  }