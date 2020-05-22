public class DxProgressIndicator {

    private final VBox vb ;
    private ProgressBar pb;
    private ProgressIndicator pi;
    private TextField tfNumbers;
    private Label lblLineNumVal;
    private Label lblAllLines;
    private double progressIncrement;
    private double progressPrevVal;
    private int lineNum;
    private Label lblFile;

    private final DoubleProperty progress = new SimpleDoubleProperty();

    public DoubleProperty progressProperty() {
        return progress ;
    }

    public final double getProgress() {
        return progressProperty().get();
    }

    public final void setProgress(double progress) {
        progressProperty().set(progress);
    }

    public DxProgressIndicator() {

        lblFile = new Label();
        final HBox hbFile = new HBox();
        hbFile.setAlignment(Pos.CENTER_LEFT);
        Label lblCurrentFile = new Label("Current file: ");
        lblCurrentFile.setMinWidth(90);
        lblCurrentFile.setFont(Font.font(null, FontWeight.BOLD, 13));
        hbFile.getChildren().addAll(lblCurrentFile, lblFile);

        pb = new ProgressBar(0);
        pb.setMinWidth(450);

        pi = new ProgressIndicator(0);

        pb.progressProperty().bind(progress);
        pi.progressProperty().bind(progress);

        final HBox hbPis = new HBox(10);
        hbPis.setAlignment(Pos.CENTER_LEFT);
        hbPis.getChildren().addAll(pb, pi);

        lblLineNumVal = new Label();
        lblLineNumVal.setMaxWidth(200);

        Label slash = new Label("  /  ");

        lblAllLines = new Label();

        final HBox hbLines = new HBox();
        hbLines.setAlignment(Pos.CENTER_LEFT);
        Label lblLineNum = new Label("    Currently parsing Line # :   ");
        lblLineNum.setFont(Font.font(null, FontWeight.BOLD, 12));
        hbLines.getChildren().addAll(lblLineNum, lblLineNumVal, slash, lblAllLines);

        tfNumbers = new TextField();
        tfNumbers.setEditable(false);
        tfNumbers.setMaxWidth(100);

        final HBox hbTrxValues = new HBox();
        hbTrxValues.setAlignment(Pos.CENTER_LEFT);
        Label lblNumbers = new Label("(transaction, step, record) = ");
        lblNumbers.setFont(Font.font(null, FontWeight.BOLD, 12));
        hbTrxValues.getChildren().addAll(lblNumbers, tfNumbers);

        vb = new VBox(10);
        vb.getChildren().addAll(hbFile, hbPis, hbLines, hbTrxValues);
        vb.setPadding(new Insets(10));

    }

    public Parent getRoot() {
        return vb ;
    }

    public void setTotalLines(long totalLines) {
        lblAllLines.setText(Long.toString(totalLines));
    }

}