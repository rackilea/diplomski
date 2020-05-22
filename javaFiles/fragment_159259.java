// Use a MouseListener so that we can get the widget-relative x,y coordinates
table.addMouseListener(new MouseAdapter() {

    @Override
    public void mouseUp(final MouseEvent e) {
        final Control oldEditor = editor.getEditor();
        if (oldEditor != null) {
            oldEditor.dispose();
        }

        // Get the Point from the MouseEvent
        final Point p = new Point(e.x, e.y);
        // Get the TreeItem corresponding to that point
        final TreeItem item = table.getItem(p);
        if (item == null) {
            return;
        }
        // Now that we know the TreeItem, we can use the getBounds() method
        // to locate the corresponding column
        for (int i = 0; i < table.getColumnCount(); ++i) {
            if (item.getBounds(i).contains(p)) {
                final int columnIndex = i;
                // The control that will be the editor must be a
                final Text newEditor = new Text(table, SWT.NONE);

                newEditor.setText(item.getText(columnIndex ));

                newEditor.addModifyListener(new ModifyListener() {
                    public void modifyText(final ModifyEvent e) {
                        final Text text = (Text) editor.getEditor();
                        editor.getItem().setText(columnIndex , text.getText());
                    }
                });
                newEditor.selectAll();
                newEditor.setFocus();
                // Set the editor for the matching column
                editor.setEditor(newEditor, item, columnIndex );
            }
        }
    }

});