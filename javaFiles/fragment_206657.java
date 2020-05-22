override protected function commitProperties():void
{
 super.commitProperties();
 if(_dataChanged)
 {
  _dataChanged = false;
  text = getText();
 }
}

private function getText():String
{
 var result:String = “Not Belongs”
 var columnCategory:Category = CategoryDataGridColumn(listData.owner.columns[listData.columnIndex]).category;
 for each(var category:Category in Product(data).categoriesList)
 {
  if(columnCategory.id == category.id)
  {
   result = “Belongs”;
   break;
  }
 }
 return result;
}