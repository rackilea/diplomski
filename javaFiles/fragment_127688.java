public class GridLayoutWithLeftAlignedButtons extends GridLayout {
    public GridLayoutWithLeftAlignedButtons() {
        super(1, 4);
        addButton("Details", FontAwesome.SEARCH);
        addButton("Copy (Inhalt)", FontAwesome.FILE_TEXT);
        addButton("Copy (Zeile)", FontAwesome.COPY);
        addButton("Copy (ID)", FontAwesome.SERVER);
    }

    private void addButton(String caption, FontAwesome icon) {
        Button newButton = new Button(caption, icon);
        newButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        newButton.addStyleName("black-background-white-text");
        newButton.setWidth("300px");
        addComponent(newButton);
    }
}