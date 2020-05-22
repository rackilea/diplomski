final Document doc = record.getDocument(); 
String author = "";

if (doc != null)
{   
    Node node = doc.selectSingleNode("//mx:datafield[@tag='100']/mx:subfield[@code='a']")
    if (node!=null)
      author = node.getText();
}