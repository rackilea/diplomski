public PanelMap() {
    String filePath = "C:\\...\\city2.png";
    CityPanel city = new CityPanel(filePath, 0, 255, 255);       
    this.setLayout(new BorderLayout());
    this.add(city, BorderLayout.CENTER);        
}