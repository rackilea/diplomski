@Controller
@Scope("prototype")
public class MenuFrameController {

@FXML
private Button generateReportButton;

@Autowired
private SpringFXMLLoader fxmlLoader ;

@FXML
void generateReportButtonClicked(ActionEvent event) throws Exception {

        try {
            Parent root = fxmlLoader.load("/fxml/reportFrame.fxml");
            Scene scene = new Scene(root);
            Stage stage = (Stage) generateReportButton.getScene().getWindow();
            stage.setTitle("Generate new report");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create Generate Window.");
        }



    }

}