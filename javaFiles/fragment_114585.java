public class ResultsPanel extends JPanel {
  public ResultsPanel() {
    // Layout our contents vertically
    BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
    this.setLayout(layout);
  }
  // method to iterate over the results from the database
  // construct an EnquiryPanel and add that EnquiryPanel to ourselves
  public void layoutEnquiryResults(ResultCollection results) {
     for (Result result : results) {
        EnquiryPanel eqPanel = new EnquiryPanel(result);
        add(eqPanel);
     }
     revalidate();
  }
}