public class NumberedCell extends TableCell{

  protected void updateItem(Object object, boolean selected){
    setText(String.valueOf(getIndex());
  }
}