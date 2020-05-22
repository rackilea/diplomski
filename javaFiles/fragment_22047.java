public enum ColourStyles { 
    BACKGROUND("#D9DADE");

    private String colourValue;

    private ColourStyles(String value) {
        colourValue = value;
    }

    public String getColourValue() {
            return colourValue;
    }

    public Color getColour(){
      return Color.decode(colourValue);
    }

}