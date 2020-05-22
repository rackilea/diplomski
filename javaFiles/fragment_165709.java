//this goes in the cycle where widgets are created
item.setData("checkButtonEditor", editor);
//here comes another widget (comboBox) for the fourth column
item.setData("checkBoxEditor", editor);

//this goes into the beggining of initialze-method
types.setRedraw(false);
TableItem[] items = types.getItems();
for (TableItem item : items)
{
    TableEditor editor = (TableEditor)item.getData("checkButtonEditor");
    editor.getEditor().dispose();
    editor.dispose();
    editor = (TableEditor)item.getData("checkBoxEditor");
    editor.getEditor().dispose();
    editor.dispose();
}
types.removeAll();
types.setRedraw(true);