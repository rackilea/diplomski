private final boolean flag;
   Employee(int flag) {
       this.flag = flag;
   }

   public int method() {
       if(flag) {
            secondMethod();
       }
       alwaysMethod();
   }