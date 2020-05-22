public class EnhancedDataGrid extends DataGrid {

  /**
   * Expose the inner CustomScrollPanel.
   */
  public CustomScrollPanel getScrollPanel() {
    HeaderPanel headerPanel = (HeaderPanel) getWidget();
    return (CustomScrollPanel) headerPanel.getContentWidget();
  }
}