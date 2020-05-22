treeTable.addGeneratedColumn("generated", new ColumnGenerator() {

@Override
public Component generateCell(Table source, final Object itemId, Object columnId){

    // Get the object associated with the row
    Object Objet = source.getItem(itemId);

    //Missing casting instruction

    if(your condition to check to render a CheckBox()){
       return new CheckBox();
    }

    return new Label("your text");
}