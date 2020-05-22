protected void createTree(JFXTreeTableView<ScanModel> tree, ObservableList<ScanModel> elements) {
    tree.setRoot(new RecursiveTreeItem<ScanModel>(elements, RecursiveTreeObject::getChildren));
    tree.setShowRoot(false);
    tree.getSelectionModel().clearSelection();

    // set sort policy for the table in two levels
    tree.setSortPolicy(t -> {
        Comparator<TreeItem<ScanModel>> studiesComparator = (r1, r2) -> {
            try {
                int r1Value = Integer.parseInt(r1.getValue().getDisplayName());
                int r2Value = Integer.parseInt(r2.getValue().getDisplayName());
                return Integer.compare(r2Value, r1Value);
            } catch (NumberFormatException e) {
                return r2.getValue().getDisplayName().compareToIgnoreCase(r1.getValue().getDisplayName());
            }
        };
        FXCollections.sort(tree.getRoot().getChildren(), studiesComparator);

        for (TreeItem<ScanModel> series : tree.getRoot().getChildren()) {
            Comparator<TreeItem<ScanModel>> seriesComparator = (r1, r2) -> {
                try {
                    int r1Value = Integer.parseInt(r1.getValue().getDisplayName());
                    int r2Value = Integer.parseInt(r2.getValue().getDisplayName());
                    return Integer.compare(r1Value, r2Value);
                } catch (NumberFormatException e) {
                    return r1.getValue().getDisplayName().compareToIgnoreCase(r2.getValue().getDisplayName());
                }
            };
            series.getChildren().sort(seriesComparator);
        }

        return true;
    });

}