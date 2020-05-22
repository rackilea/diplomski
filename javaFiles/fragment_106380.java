public class FXMLController implements Initializable {

  @FXML
  private Button btBuscaOrdem;

  @FXML
  private Button btBuscaLote;

  @Override
  public void initialize(URL url, ResourceBundle rb) {

    // number of buttons
    int iconsSize = 2;
    // the glyph to set
    FontAwesomeIcon glyph = FontAwesomeIcon.SEARCH;
    /*
     * the style to set, glyph have two styleable properties:
     *
     * -glyph-size
     * -glyph-name
     */
    String style = "-fx-fill: white; -glyph-size: 42px;";
    // where the icon instances will be stored;
    GlyphIcon<?>[] icons = new GlyphIcon<?>[iconsSize];
    // create instances
    for (int i = 0; i < icons.length; i++) {
      icons[i] = GlyphsBuilder.create(FontAwesomeIconView.class)
          .glyph(glyph)
          .style(style)
          .build();
    }

    btBuscaOrdem.setGraphic(icons[0]);
    btBuscaLote.setGraphic(icons[1]);

    // two possibilities to only show graphic
    btBuscaOrdem.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    btBuscaLote.setStyle("-fx-content-display: graphic-only;");
  }
}