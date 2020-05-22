Model rootModel = new Model("Root");
    final CheckBoxTreeItem<Model> root = new CheckBoxTreeItem<>(rootModel);
    root.selectedProperty().bindBidirectional(rootModel.selectedProperty());

    Model parentModel = new Model("Parent");
    final CheckBoxTreeItem<Model> parent = new CheckBoxTreeItem<>( parentModel);
    parent.selectedProperty().bindBidirectional(parentModel.selectedProperty());

    Model childModel = new Model("Child");
    final CheckBoxTreeItem<Model> child = new CheckBoxTreeItem<>(childModel);
    child.selectedProperty().bindBidirectional(childModel.selectedProperty());