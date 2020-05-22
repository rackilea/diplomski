public class OverviewController {

       private Model model ;

       public void initModel(Model model) {
           this.model = model ;
           this.model.getPoints().addListener((Change<? extends Point> change) -> {
               while (change.next()) {
                   if (change.wasAdded()) {
                       for (Point p : change.getAddedSublist()) {
                           draw(p.x, p.y);
                       }
                   }
               }
           });
       }

       @FXML
       Canvas canvas;

       public void test(){
         Point point = new Point(5,5);
         model.getPoints().add(point);
       }

       public void draw(double x, double y){

         GraphicsContext gc = canvas.getGraphicsContext2D();
         gc.setFill(Color.rgb(255, 0, 0));
         gc.fillOval(x-4, y-4, 8, 8);

       }
 }