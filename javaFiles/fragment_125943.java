Button addMenu = new Button("add MenuItem to corner");
addMenu.setOnAction(e -> {
    TableViewSkin skin = (TableViewSkin) table.getSkin();
    TableHeaderRow header = skin.getTableHeaderRow();
    ContextMenu menu = (ContextMenu) invokeGetFieldValue(
                    TableHeaderRow.class, 
                    header, "columnPopupMenu");
    ControlAcceleratorSupport.addAcceleratorsIntoScene(menu.getItems(), table);
[...]