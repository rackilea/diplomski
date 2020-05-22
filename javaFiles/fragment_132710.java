public class Question4 extends Application
{

    public int carRightSide = 80;

    @Override
    public void start( Stage obPrimeStage ) throws Exception
    {

        Pane obPane = new Pane();           

        Scene obScene = new Scene(obPane, 300, 350, Color.ANTIQUEWHITE);
        obPrimeStage.setScene(obScene);//Add scene here
        obPrimeStage.setTitle("Driving Cars");
        obPrimeStage.setResizable(false);
        obPrimeStage.show();//Show Stage so that the size will be calculated

        Circle obWheelOne = new Circle(20, Color.BLACK);
        obWheelOne.setRadius(20);
        Circle obWheelTwo = new Circle(20, Color.BLACK);
        obWheelTwo.setRadius(20);

        Rectangle obBody = new Rectangle(carRightSide, 40, Color.LIGHTBLUE);
        obBody.setX(obScene.getWidth() - carRightSide);
        obBody.setY(40);

        obPane.getChildren().add(obBody);
        obPane.getChildren().add(obWheelOne);
        obPane.getChildren().add(obWheelTwo);
    }

    public static void main( String[] args )
    {
        Application.launch(args);
    }
}