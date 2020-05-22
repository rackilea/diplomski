public class SwitchSceneSample extends Application {
public static void main(String[] args) {
    launch(args);
}

Stage window;
Scene scene1, scene2;

@Override
public void start(Stage primaryStage) throws Exception {
    // I am using window as primaryStage
    window = primaryStage;
    // Label 1
    Label label1 = new Label("Welcome to the first scene!");
    // Label 2
    Label label2 = new Label("This is second scene!");
    // Button 1, by pressing this button primaryStage will be set as scene 2
    Button button1 = new Button("Go to scene 2");
    button1.setOnAction(e -> window.setScene(scene2));
    // Button 2, by pressing this button primaryStage will be set as scene 1
    Button button2 = new Button("Click to go scene 1");
    button2.setOnAction(e -> window.setScene(scene1));
    // Creating an object of the class'LayoutOne.java'
    LayoutOne l1 = new LayoutOne();
    // set my scene 1(by calling method called 'sceneView1()' from class 'LayoutOne.java')
    scene1 = new Scene(l1.sceneView1(label1, button1), 200, 200);
    // Set my scene 2 inside my main class
    StackPane layout2 = new StackPane();
    layout2.getChildren().addAll(label2, button2);
    scene2 = new Scene(layout2, 600, 300);
    // Making my 
    window.setScene(scene1);
    window.setTitle("Scene Switch Sample");
    window.show();
}