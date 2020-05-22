class A{

method1(){
 int result = //do something
 if(result > 1){
   method2();
 }else{
   method3(); 
 }
}

method2(){
   try{
   // do something
   } catch(Exception e){ // If left at all exceptions, any error will call Method3()
     //throw a message
     //Move to call method3()
     method3();
   }
 }

 method3(){
  //What you origianlly wanted to do inside the else block

 }
}

}