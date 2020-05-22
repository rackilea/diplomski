interface DocumentHandler {
    void process(Document d);
}

class ExportToPdf implements DocumentHandler { ... }
class AppendToParentPdf implements DocumentHandler { ... }

// Now you're just passing the interface whose implementation does something with the document
void handleDocument(DocumentHandler parentHandler, DocumentHandler childHandler) {
    for(Document parent : documents) {
        parentHandler.process(parent);

        for(Document child : parent.children()) {
            childHandler.process(child);
        }
    }
}

DocumentHandler appendToParent = new AppendToParentPdf();
DocumentHandler exportToPdf = new ExportToPdf();

// pass the child/parent handlers as needed
handleDocument(exportToPdf, appendToParent);
handleDocument(exportToPdf, exportToPdf);