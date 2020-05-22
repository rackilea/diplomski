PdfPTable table = new PdfPTable(7);         
    table.setWidthPercentage(100);
    PdfPCell imageCell = new PdfPCell(image);       
    imageCell.setBorder(0);
    imageCell.setRowspan(2);        
    table.addCell(imageCell);

    for(int i=0; i<6;i++) {
        PdfPCell blankCell = new PdfPCell();
        blankCell.setBorder(0);
        blankCell.setFixedHeight(20f);
        table.addCell(blankCell);
    }

    PdfPCell cell22 = new PdfPCell(new Phrase("ID Number"));
    table.addCell(cell22);

    PdfPCell cell23 = new PdfPCell(new Phrase("9"));                
    table.addCell(cell23);

    PdfPCell cell24 = new PdfPCell(new Phrase("6"));        
    table.addCell(cell24);

    PdfPCell cell25 = new PdfPCell(new Phrase("0"));        
    table.addCell(cell25);

    PdfPCell cell26 = new PdfPCell(new Phrase("5"));        
    table.addCell(cell26);

    PdfPCell cell27 = new PdfPCell(new Phrase("1"));        
    table.addCell(cell27);      

    document.add(table);