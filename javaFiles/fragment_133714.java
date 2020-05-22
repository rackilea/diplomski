class MyObject{
   String thing1;
   double thing2;
   int thing3;

   public MyObject copy(){
      MyObject copy = new MyObject();
      copy.thing1 = this.thing1;
      copy.thing2 = this.thing2;
      copy.thing3 = this.thing3;
   }

}