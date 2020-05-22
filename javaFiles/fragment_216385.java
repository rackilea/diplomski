public class Utility {
        public static void switchScene(URL path) {
            Stage stage = getMainStage(); // Assume this returns the primary stage
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(path);

            try {
                Parent root = loader.load();
                Controller controller = loader.getController();
                controller.start();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }