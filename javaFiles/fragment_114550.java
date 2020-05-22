public static <T> T[] f1(T[] args){
      return args;  //That one works because we return T[]
    }
    public static <T> T[] f2(Object[] args){
      return (T[])args;   //That one also works because we return T[]
    }