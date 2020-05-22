public class EstructuraPresenter implements Initializable {

    private static final Logger LOG = getLogger(EstructuraPresenter.class.getName());

    @FXML
    ToggleButton btnAlumnos, btnEstadisticas;
    @FXML
    StackPane pContenedor;

    @Inject
    private AlumnosView alumnosview;
    @Inject
    private EstadisticasView estadisticasview;
    @Inject
    private DataModel datos;

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        ((EstadisticasPresenter) estadisticasview.getPresenter()).getLinkTotalAlumnos().setOnAction((ActionEvent event) -> {
            this.cambiarSeccion("Alumnos");
        });

        //This call is from first time, where program starts to show by default Alumnos sub-window
        cambiarSeccion("Alumnos");

        btnAlumnos.setOnAction((ActionEvent event) -> {
            cambiarSeccion("Alumnos");
        });
        btnEstadisticas.setOnAction((ActionEvent event) -> {
            cambiarSeccion("Estadisticas");
        });
    }

    public void cambiarSeccion(String nombreVentana) {
        try {
            btnAlumnos.setSelected(false);
            btnEstadisticas.setSelected(false);

            switch (nombreVentana) {
                case "Alumnos":
                    if (btnAlumnos.isSelected() == false) {
                        sepTitulo.setVisible(true);
                        lbTitulo.setText("Alumnos");
                        btnAlumnos.setSelected(true);
                        alumnosview.getViewAsync(pContenedor.getChildren()::setAll);
                        pContenedor.getChildren().setAll(alumnosview.getView());
                    }
                    break;
                case "Estadisticas":
                    if (btnEstadisticas.isSelected() == false) {
                        sepTitulo.setVisible(true);
                        lbTitulo.setText("Estadísticas");
                        btnEstadisticas.setSelected(true);
                        estadisticasview.getViewAsync(pContenedor.getChildren()::setAll);
                    }
                    break;
            }
        }
        catch (Exception e) {
            LOG.log(Level.SEVERE, e.toString());
            new Dialogos().mostrarExcepcion(null, e);
        }
    }
}