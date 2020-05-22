@Controller
@Scope("prototype")
public class MenuFrameController {

@FXML
private Button generateReportButton;

@Autowired
private ApplicationContext springContext ;

@FXML
void generateReportButtonClicked(ActionEvent event) throws Exception {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reportFrame.fxml"));
            fxmlLoader.setControllerFactory(springContext::getBean);
            Parent root = fxmlLoader.load();
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