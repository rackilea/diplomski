static class A {   
   int x; 

   public A( int i) {    
    x = i;
   }
 }


static  class B {
   int x; 

   public B( int i) {    
    x = i;
   }

  public int hashCode() {
    final int prime = 31;
    return prime * x;
  }

  public boolean equals( Object obj ) {
    //by contract you should always override equals and hashCode together
    //also note that some checks are omitted for simplicity's sake (obj might be null etc.)
    return getClass().equals( obj.getClass()) && x == ((B)obj).x;
  }
}