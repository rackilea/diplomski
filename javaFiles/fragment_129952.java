int n = 0;
for (int i = 0; i < 5; i++) {
    if (n % 2 == 0) {
        doc.setLeftMargin(100);
    } else {
        doc.setLeftMargin(200);
    }

    // Make sure to set margins before adding elements to new page
    if (i > 0) {
        doc.add(new AreaBreak());
    }
    doc.add(new Paragraph("Hello"));

    n++;
}