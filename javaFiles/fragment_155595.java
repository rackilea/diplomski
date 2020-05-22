private void addBooleanPropertyColumn(Grid theGrid, String propertyName, String caption) {
    CheckBox bBox = new CheckBox();  
    Column<RegistrationRecord, String> adultFlagColumn = theGrid.addColumn(record->
        "<span class=\"v-checkbox v-widget\"><input type=\"checkbox\" id=\"my-uid-1\" " + returnChecked(propertyName, record) + "  > <label for=\"my-uid-1\"></label> </span>",
        new HtmlRenderer());
    adultFlagColumn.setId(propertyName)
    .setCaption(caption)
    .setEditorComponent(bBox) 
    .setExpandRatio(1); 
}