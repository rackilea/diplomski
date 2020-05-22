PdfFormField textFormField = PdfFormField.createText(
        pdf,
        new Rectangle(50, 50, 200, 15),
        "vo-1-text", "bla", font, 12.0f,
        false, // multiline parameter
        PdfAConformanceLevel.PDF_A_3A // <-- this is the important one
);