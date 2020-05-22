public class SubClass extends Pane {   

   Circle c = new Circle(100.0f,100.0f,100.0f);

   public SubClass() {
        getChildren().add(c);
   }

}