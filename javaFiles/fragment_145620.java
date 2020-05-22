public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            VBox root = new VBox();
            Scene scene = new Scene(root,400,400);

            // Extensions that are valid to be drag-n-dropped
            List<String> validExtensions = Arrays.asList("jpg", "png");

            root.setOnDragOver(event -> {
                // On drag over if the DragBoard has files
                if (event.getGestureSource() != root && event.getDragboard().hasFiles()) {
                    // All files on the dragboard must have an accepted extension
                    if (!validExtensions.containsAll(
                            event.getDragboard().getFiles().stream()
                                    .map(file -> getExtension(file.getName()))
                                    .collect(Collectors.toList()))) {

                        event.consume();
                        return;
                    }

                    // Allow for both copying and moving
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            });

            root.setOnDragDropped(event -> {
                boolean success = false;
                if (event.getGestureSource() != root && event.getDragboard().hasFiles()) {
                    // Print files
                    event.getDragboard().getFiles().forEach(file -> System.out.println(file.getAbsolutePath()));
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            });

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Method to to get extension of a file
    private String getExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0 && i < fileName.length() - 1) //if the name is not empty
            return fileName.substring(i + 1).toLowerCase();

        return extension;
    }

    public static void main(String[] args) {
        launch(args);
    }
}