final Image closedImage = new Image(getClass().getResourceAsStream("folder.png"));
final Image openImage = new Image(getClass().getResourceAsStream("folder-open.png"));

tree.setCellFactory(param -> new TreeCell<File>() {

    {
        final ImageView imageView = new ImageView();
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        final ChangeListener<Boolean> expansionListener = new WeakChangeListener<>((o, oldValue, newValue) -> {
            imageView.setImage(newValue ? openImage : closedImage);
        });

        // add change listener to expanded property of item
        treeItemProperty().addListener((o, oldValue, newValue) -> {
            if (oldValue != null) {
                oldValue.expandedProperty().removeListener(expansionListener);
            }
            if (newValue != null) {
                newValue.expandedProperty().addListener(expansionListener);
                expansionListener.changed(null, null, newValue.isExpanded()); // trigger for initial value
            }
        });

        setDisclosureNode(imageView);
    }

    @Override
    public void updateItem(File item, boolean empty) {
        super.updateItem(item, empty);

        setText((empty || item == null) ? "" : item.getName());
    }
});