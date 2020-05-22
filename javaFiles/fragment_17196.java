document.open();
PdfService event = new PdfService();
event.setHeader(date.toString());
event.onOpenDocument(writer, document);
event.onEndPage(writer, document);
event.onCloseDocument(writer, document);
writer.setPageEvent(event);