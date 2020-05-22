Class A{
   B b;
   void setB(B b) {
       this.b = b;
   }
};

A a;
B b;
A.setB(b);

b.change(); //changed in A