public void start(Stage stage) throws FileNotFoundException {
    //Creating an image 
    Image image = new Image(new FileInputStream("file path"));

    //Setting the image view 1 
    ImageView imageView1 = new ImageView(image); 

    //Creating a Group object  
    Group root = new Group(imageView1);  

    //Creating a scene object 
    Scene scene = new Scene(root, 600, 400);  

    //Adding scene to the stage 
    stage.setScene(scene);  

    //Displaying the contents of the stage
    stage.show(); 
}