public class GameThingy {
      //...

     private void doStuff(GameObject gameObject) {
         float gravity = 5*gameObject.returnSomething("hieght");
         gameObject.setSomething("velocyty", gravity+50);
     }
}