Window window = new Window();
        ((VerticalLayout) window.getContent()).setSizeFull();

Embedded pdf = new Embedded("test", new StreamResource(new StreamSource() {     
            public InputStream getStream() {
                InputStream is = PdfWindow.class.getClassLoader().getResourceAsStream("Lifestyle-Tracker-Promo.pdf");
                return is;
            }
        }, "file.pdf", mainApp));   

pdf.setType(Embedded.TYPE_BROWSER);
pdf.setMimeType("application/pdf"); 
pdf.setSizeFull();

window.addComponent(pdf);
getMainWindow().addWindow(window);