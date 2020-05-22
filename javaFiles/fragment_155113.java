private static class MyTreeCellEditor extends DefaultTreeCellEditor {

        public MyTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
            super(tree, renderer);
        }
        Text newText;
        Real newReal;
        Size newSize;
        Integer newInt;
        Boolean newBool;
        Table newTable;

        @Override
        public Component getTreeCellEditorComponent(JTree jtree, Object o, boolean bln, boolean bln1, boolean bln2, int i) {
            return super.getTreeCellEditorComponent(jtree, o, bln, bln1, bln2, i); //To change body of generated methods, choose Tools | Templates.
        }

    @Override
    public Object getCellEditorValue() {
        String value = (String) super.getCellEditorValue();
        DefaultMutableTreeNode testNode = (DefaultMutableTreeNode) super.tree.getLastSelectedPathComponent();

        Object objToChange = testNode.getUserObject();

        while (objToChange instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) objToChange;
            objToChange = parentNode.getUserObject();
        }

        if (testNode.getChildCount() > 0) {
            value += " (" + testNode.getChildCount() + ")";
        }

        if (objToChange instanceof Text) {
            newText = (Text) objToChange;
            newText.setName(value);
            return newText;
        } else if (objToChange instanceof Real) {
            newReal = (Real) objToChange;
            newReal.setName(value);
            return newReal;
        } else if (objToChange instanceof Size) {
            newSize = (Size) objToChange;
            newSize.setName(value);
            return newSize;
        } else if (objToChange instanceof Integer) {
            newInt = (Integer) objToChange;
            newInt.setName(value);
            return newInt;
        } else if (objToChange instanceof Boolean) {
            newBool = (Boolean) objToChange;
            newBool.setName(value);
            return newBool;
        } else if (objToChange instanceof Table) {
            newTable = (Table) objToChange;
            newTable.setName(value);
            return newTable;
        } else {
            return new Text("unexpected object 02");
        }
    }