public class Test extends Application implements EventHandler<KeyEvent>{
    static Stage theStage;
    static Scene scene1, scene2;

    // top box
    HBox topBox = new HBox();

    // bottom box
    HBox bottomBox = new HBox();

    // grid dimensions (I'm trying to manipulate these variables)
    int rowSize;
    int colSize;
    int tileSize;

    GridPane gridPane;
    GridMapT gridMap;

    @Override
    public void start(Stage firstStage) throws Exception{
        theStage = firstStage;

        // scene 2 //////////////
        Label label2 = new Label("scene 2: choose a stage");
        Button stage1_btn = new Button("Room 5x5");
        Button stage2_btn = new Button("Room 7x7");
        Button stage3_btn = new Button("Room 10x10");
        Button button5 = new Button("Exit");

        stage1_btn.setOnAction(e -> {
            startStage1();
        });
        stage2_btn.setOnAction(e -> {
            startStage2();
        });
        stage3_btn.setOnAction(e -> {
            startStage3();
        });
        button5.setOnAction(e -> System.exit(0));

        // Layout1
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label2, stage1_btn, stage2_btn, stage3_btn, button5);
        scene1 = new Scene(layout, 800, 600);

        // Scene 3 ////////////////////
        // top box
        Label title = new Label("Map test");

        topBox.getChildren().add(title);

        // bottom box
        Label instruction = new Label("");

        bottomBox.getChildren().add(instruction);

        // scene 3
        BorderPane gameScreen = new BorderPane();

        scene2 = new Scene(gameScreen);

        // set up gridPane
        gridPane = new GridPane();

        ////// ////////////////////////////////////////////////////////////////////////
        // add a clickable reset and Debug Mode to bottom box

        Button resetBtn = new Button();
        resetBtn.setText("Quit game");

        bottomBox.getChildren().add(resetBtn);

        resetBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>(){
            @Override
            public void handle(Event event){
                try {
                    //There's no need to call start method anymore.
                    //Think of the stage like it's your app's window
                    //and of a scene like it is window's content.
                    //restart(firstStage);
                    firstStage.setScene(scene1);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        });

        // keyboard input
        scene2.setOnKeyPressed(this);

        // setting up the whole borderPane
        gameScreen.setTop(topBox);
        gameScreen.setBottom(bottomBox);
        gameScreen.setCenter(gridPane);

        // set scene1 as start up screen
        firstStage.setScene(scene1);
        firstStage.show();

    }

    //TODO pass rowSize and colSize here
    private void createMap(){
        gridMap = new GridMapT(rowSize, colSize);
    }

    //TODO pass gridMap
    private void redrawMap(){
        gridPane.getChildren().clear();

        for (int x = 0; x < rowSize; x++) {
            for (int y = 0; y < colSize; y++) {
                String grid = gridMap.getMap()[x][y];

                // floor labels
                if (grid == "floor") {
                    Label table = new Label("F");
                    table.setMinWidth(tileSize);
                    table.setMinHeight(tileSize);
                    gridPane.add(table, x, y);
                }

                // wall labels
                if (grid == "wall") {
                    Label table = new Label("W");
                    table.setMinWidth(tileSize);
                    table.setMinHeight(tileSize);
                    gridPane.add(table, x, y);
                }
            }
        }
    }

    // restart method
    public void restart(Stage stage) throws Exception{

        topBox.getChildren().clear();
        bottomBox.getChildren().clear();
        gridPane.getChildren().clear();
        gridMap = new GridMapT(rowSize, colSize);

        start(stage);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    // stage setting methods
    public void startStage1(){
        rowSize = 21;
        colSize = 21;
        tileSize = 40;

        createMap();
        redrawMap();
        theStage.setScene(scene2);
    }

    public void startStage2(){
        rowSize = 29;
        colSize = 29;
        tileSize = 30;

        createMap();
        redrawMap();
        theStage.setScene(scene2);
    }

    public void startStage3(){
        rowSize = 41;
        colSize = 41;
        tileSize = 20;

        createMap();
        redrawMap();
        theStage.setScene(scene2);
    }

    @Override
    public void handle(KeyEvent event){
        // TODO Auto-generated method stub

    }

    public static void main(String[] args){
        launch(args);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // GridMap Class

    public class GridMapT{

        private String[][] map;

        public GridMapT(int rowSize, int colSize){

            this.map = new String[rowSize][colSize];

            // set up wall and fog
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {

                    if (i % 4 == 0 || j % 4 == 0) {
                        map[i][j] = "wall";
                    } else {
                        map[i][j] = "floor";
                    }

                }
            }

        }

        public String[][] getMap(){
            return map;
        }

    }
}