public enum MyButtons {
  WALK,
  SIT,
   ...
   }
[...]
 //ON CLIENT
 Button whatever = new Button(MyButtons.WALK);

 //ON SERVER
 MyButtons action = whatever.getType(); 
// getType() should provide the value from the constructor


 switch(action)
   {
    case WALK : doStuff();
    case SIT : doStuff();
     ...
   }