package vizsgaquiz;

    import java.io.File;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.FileChooser;
    import javafx.stage.Stage;


    public class VizsgaQuiz extends Application {

      ArrayList<String> kerdeslista = new ArrayList<String>();
      String a ="a";


      @Override
      public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Foablak.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Quiz Játék");
        stage.show();
        save(stage);
      }

      public void save(Stage stage){
        kerdeslista.add(a);

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(stage);

        if(file != null){
          saveFile(kerdeslista, file);
        }
      }


      /**
       * @param args the command line arguments
       */
      public static void main(String[] args) {
        launch(args);
      }

      public static void saveFile(ArrayList<String> list, File file) {
        try {
          PrintWriter out = new PrintWriter(file);
          for (String val : list)
            out.println(val + "\n");
          out.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

    }