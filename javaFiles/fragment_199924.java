document = new Document();
document.open();
[...]
PdfWriter.getInstance(document, file);
[...]
[for `Samples` times]
    document.open();
    [add some paragraphs]
    [add an image]
[end for]
document.close();