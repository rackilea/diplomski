public void setGraphicPanel(GraphicPanel graphicPanel) {
    this.removeAll();
    this.graphicPanel = graphicPanel;
    this.add(graphicPanel);
    this.revalidate();   
}