public class Server extends Application {
    private static Object lock = new Object();
    private static ServerLog serverLog = new ServerLog();

    public static void getService(Socket s) throws IOException { ... }

    public static void main(String[] args){
        launch(args);
        new File("users").mkdir();
        try {
            ServerSocket socket = new ServerSocket(8189);

                while(true) {
                    Socket s = socket.accept();
                    getService(s);
                }

        }catch(IOException e){e.printStackTrace();}

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/server.fxml"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Server Log");
        primaryStage.show();
    }
}