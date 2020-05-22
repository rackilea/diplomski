public static int[] getPageSizes(byte[] input) throws IOException {
        PdfReader reader;
        reader = new PdfReader(input);
        int pageCount = reader.getNumberOfPages();
        int[] pageSizes = new int[pageCount];
        for (int i = 0; i < pageCount; i++) {
            try {
                Document doc = new Document();
                ByteArrayOutputStream bous = new ByteArrayOutputStream();
                PdfCopy copy= new PdfCopy(doc, bous);
                doc.open();
                PdfImportedPage page = copy.getImportedPage(reader, i+1);
                copy.addPage(page);
                doc.close();
                pageSizes[i] = bous.size();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

        reader.close();
        return pageSizes;
    }