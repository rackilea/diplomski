interface DoFunction{
   void do();
}

void hello(DoFunction function){
   function.do();
}

void setup(){
   hello(new DoFunction(){
      void do(){
         println("here");
      }
   });
}