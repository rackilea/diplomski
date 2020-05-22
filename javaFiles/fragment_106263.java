class SampleController implements Initializable {
  @FXML
  private Label label;

  @FXML 
  private void handleButtonAction(ActionEvent event) {
    EntityManager em = SampleApplication.createEntityManager();
    Moyendidactique moyenDidactique = new Moyendidactique("1", "moyen1", "Type1");
    em.persist(moyenDidactique);
    em.close();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {}
}