for (int m = 0; m < pdfDocument.getPageSize().getWidth() / 2 && m < pdfDocument.getPageSize().getHeight() / 2; m += 100)
    {
        pdfDocument.setMargins(m, m, m, m);
        pdfDocument.newPage();
        pdfDocument.add(new Paragraph(test));
    }