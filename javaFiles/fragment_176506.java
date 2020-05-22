@Component
public class DemoController {
    @FXML
    private Label usernameLabel; 

    @Autowired
    public void mySpringService;

    public void initialize() {
        usernameLabel.setText(
            mySpringService.getLoggedInUsername()
        );
    }
}