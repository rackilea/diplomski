String textNL = "I am trying to create a PDF file with a lot of text contents in the document. I am using PDFBox.\nFurthermore, I have added some newline characters to the string at which lines also shall be broken.\nIt should work alright like this..."; 
List<String> lines = new ArrayList<String>();
for (String text : textNL.split("\n"))
{
    int lastSpace = -1;
    while (text.length() > 0)
    {
        [...]
    }
}