public class JsonMain extends Application {

    static List<Coordinate> coordinates = new ArrayList<>();

    private static final String ITEMS_NAME = "items";
    private static final String LATITUDE_PROPERTY = "latitude";
    private static final String LONGITUDE_PROPERTY = "longitude";
    private static final String CRASH_NAME = "em_type_name";

    static void parseCrashCoordinates(final JsonReader jsonReader, final ICoordinatesListener listener)
            throws IOException {    
        // Reading JSON file
    }

     // Collecting all coordinates in ArrayList.
    private static void testCollecting()
            throws IOException {
      //  List<Coordinate> coordinates = new ArrayList<>();
        readAndParse((lat, lng) -> coordinates.add(new Coordinate(lat, lng)));
        System.out.println(coordinates.size());   
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  
        throws IOException, URISyntaxException, MalformedURLException {

        testCollecting();  


     // Initialize our clustering class with locations, minimum points in cluster and max Distance
        DBSCANClusterer clusterer = new DBSCANClusterer(coordinates, 2, 2);

        GoogleMap gm = new GoogleMap(clusterer);

        // create scene
        stage.setTitle("Web Map");
        Scene scene = new Scene(gm.getView(), 1000, 700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.show();

    }

}