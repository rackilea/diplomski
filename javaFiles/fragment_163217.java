public class YourActivity extend Activity implements MyDelegate{
      @override  
      void oncreate(){
           //create new button with a delegate
        MyLongPressCustomButton btn = new  MyLongPressCustomButton(this);
         //do something
      }

      //real work is here
      @override  
      public void cancelLongPress(){

      }
  }