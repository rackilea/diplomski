Style style = new Style();
// You can set other attributes here 
style.setAttributeValue(CellStyleAttributes.BACKGROUND_COLOR, GUIHelper.COLOR_RED);

configRegistry.registerConfigAttribute(
    CellConfigAttributes.CELL_STYLE,    // attribute to apply
    style,                  // value of the attribute
    DisplayMode.NORMAL,         // apply during normal rendering
    CELL_LABEL);    

        // apply for all cells with this label