String text = "your xml here";
Document document = DocumentHelper.parseText(text);

public void bar(Document document) {
   List list = document.selectNodes( "//statement" );
   // loop through node data
}