public class EstadisticasPresenter implements Initializable {

    private static final Logger LOG = getLogger(EstadisticasPresenter.class.getName());

    @FXML
    Hyperlink linkTotalAlumnos;

    @Inject
    private DataModel datamodel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //Getters that I use in EstructuraPresenter controller to set up event handlers
    public Hyperlink getLinkTotalAlumnos() {
        return linkTotalAlumnos;
    }
}