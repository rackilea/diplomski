private int getNumberOfPages(PdfReader reader) {
            int pages = 0;
            PdfObject obj;
            for (int i = 1; i <= reader.getXrefSize(); i++) {
                obj = reader.getPdfObject(i);
                if (obj != null && obj.isStream()) {
                    PRStream stream = (PRStream)obj;
                    byte[] b;
                    try {
                        b = PdfReader.getStreamBytes(stream);
                        PdfReader pdfReader = new PdfReader(b);
                        pages += pdfReader.getNumberOfPages();
                    } catch(InvalidPdfException e) {

                    } catch (IOException e) {

                    }

                }
            }
            if (pages == 0) {
                pages = reader.getNumberOfPages();
            }
            return pages;
        }