//Load the document
Document doc = new Document(MyDir + "in.docx");

//Get the first table in the document
Table table = (Table)doc.getChild(NodeType.TABLE, 0, true);

//Get the first cell of first row
Cell cell = (Cell)table.getRows().get(0).getCells().get(0);

//Change the color of text
for (Run run : (Iterable<Run>)cell.getChildNodes(NodeType.RUN, true))
{
    run.getFont().setColor(Color.BLUE);
}

//Save the document
doc.save(MyDir + "Out.docx");