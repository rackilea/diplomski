public class TableUtils {

    /**
     * Make table menu button visible and replace the context menu with a custom context menu via reflection.
     * The preferred height is modified so that an empty header row remains visible. This is needed in case you remove all columns, so that the menu button won't disappear with the row header.
     * IMPORTANT: Modification is only possible AFTER the table has been made visible, otherwise you'd get a NullPointerException
     * @param tableView
     */
    public static void addCustomTableMenu( TreeTableView tableView) {

        // enable table menu
        tableView.setTableMenuButtonVisible(true);

        // replace internal mouse listener with custom listener 
        setCustomContextMenu( tableView);

    }

    private static void setCustomContextMenu( TreeTableView table) {

        TreeTableViewSkin<?> tableSkin = (TreeTableViewSkin<?>) table.getSkin();

        // get all children of the skin
        ObservableList<Node> children = tableSkin.getChildren();

        // find the TableHeaderRow child
        for (int i = 0; i < children.size(); i++) {

            Node node = children.get(i);

            if (node instanceof TableHeaderRow) {

                TableHeaderRow tableHeaderRow = (TableHeaderRow) node;

                // setting the preferred height for the table header row
                // if the preferred height isn't set, then the table header would disappear if there are no visible columns
                // and with it the table menu button
                // by setting the preferred height the header will always be visible
                // note: this may need adjustments in case you have different heights in columns (eg when you use grouping)
                double defaultHeight = tableHeaderRow.getHeight();
                tableHeaderRow.setPrefHeight(defaultHeight);

                for( Node child: tableHeaderRow.getChildren()) {

                    // child identified as cornerRegion in TableHeaderRow.java
                    if( child.getStyleClass().contains( "show-hide-columns-button")) {

                        // get the context menu
                        ContextMenu columnPopupMenu = createContextMenu( table);

                        // replace mouse listener
                        child.setOnMousePressed(me -> {
                            // show a popupMenu which lists all columns
                            columnPopupMenu.show(child, Side.BOTTOM, 0, 0);
                            me.consume();
                        });
                    }
                }

            }
        }
    }

    /**
     * Create a menu with custom items. The important thing is that the menu remains open while you click on the menu items.
     * @param cm
     * @param table
     */
    private static ContextMenu createContextMenu( TreeTableView table) {

        ContextMenu cm = new ContextMenu();

        // create new context menu
        CustomMenuItem cmi;

        // select all item
        Label showAll = new Label("Show all");
        showAll.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                for (Object obj : table.getColumns()) {
                    ((TreeTableColumn<?, ?>) obj).setVisible(true);
                }
            }

        });

        cmi = new CustomMenuItem(showAll);
        cmi.setHideOnClick(false);
        cm.getItems().add(cmi);

        // deselect all item
        Label hideAll = new Label("Hide all");
        hideAll.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                for (Object obj : table.getColumns()) {
                    ((TreeTableColumn<?, ?>) obj).setVisible(false);
                }
            }

        });

        cmi = new CustomMenuItem(hideAll);
        cmi.setHideOnClick(false);
        cm.getItems().add(cmi);

        // separator
        cm.getItems().add(new SeparatorMenuItem());

        // menu item for each of the available columns
        for (Object obj : table.getColumns()) {

            TreeTableColumn<?, ?> tableColumn = (TreeTableColumn<?, ?>) obj;

            CheckBox cb = new CheckBox(tableColumn.getText());
            cb.selectedProperty().bindBidirectional(tableColumn.visibleProperty());

            cmi = new CustomMenuItem(cb);
            cmi.setHideOnClick(false);

            cm.getItems().add(cmi);
        }

        return cm;
    }
}