public class Exercise_17_5 extends Application{
    @Override 
    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        Button btWrite = new Button("Write");
        Button btRead = new Button("Read");
        hbox.getChildren().addAll(btWrite, btRead);
        hbox.setPadding(new Insets(5,5,5,5));
        pane.setBottom(hbox);

        TextArea taDisplay = new TextArea();
        taDisplay.setWrapText(true);
        pane.setCenter(taDisplay);


        primaryStage.setTitle("Exercise 17_05");
        Scene scene = new Scene(pane, 350,250);
        primaryStage.setScene(scene);
        primaryStage.show();

        btWrite.setOnAction(e -> {
            try {
                writeData();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        btRead.setOnAction(e -> {
            try {
                taDisplay.setText(readData());
            } catch (Exception e1) {
                taDisplay.setText("don't be stupid. You have to write data first");
            }
        });

    }

    int[] intArray = {1,2,3,4,5};
    double[] doubleArray = {5.5};
    Date[] dateArray = {new Date()};

    private String readData() throws Exception{
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_05.dat"));

        int[] newIntArray = (int[])(input.readObject());
        double[] newDoubleArray = (double[])(input.readObject());
        Date[] newDateArray = (Date[])(input.readObject());

        String txt = "";

        for(int i = 0; i < newIntArray.length; i++){
            txt = txt + " " + newIntArray[i];
        }

        txt = txt + "\n" + newDoubleArray[0] + "\n" + newDateArray[0];
        input.close();
        return txt;
    }

    private void writeData() throws Exception {

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_05.dat"));

        output.writeObject(intArray);
        output.writeObject(doubleArray);
        output.writeObject(dateArray);

        output.close();
    }



    public static void main(String[] args){
        Application.launch(args);
    }
}