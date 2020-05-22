class MyKeyClass extends Object {
   String a;
   String b;
   String c;

   public MyKeyClass(String a, String b, String c) {
       this.a = a;
       this.b = b;
       this.c = c;
   }

   @Override
   public boolean equals(Object obj) {
       if (!(obj instanceof MyKeyClass))
          return false;
       else {
           MyKeyClass mkc = (MyKeyClass) obj;
            return this.a.equals(mkc.a) && this.b.equals(mkc.b)
                  && this.c.equals(mkc.c);

       }
    }
    @Override
    // This needs to be implemented shrewedly.I think my logic is bad.
    public int hashCode(){
       return a.hashCode()-b.hashCode()-c.hashCode();
    }
   }