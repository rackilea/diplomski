PDDocument document = new PDDocument();
PdfRenderingEndorsementAlternative renderer = new PdfRenderingEndorsementAlternative(document, logoStream, header);

renderer.render(
        new BandColumn(leftHalfPageField, "Nombre del contrato/asegurado:", "Prueba Jesus Fac No Prop"),
        new BandColumn(rightHalfPageField, "Nombre del contrato/asegurado:", "Prueba Jesus Fac No Prop con Endoso")
        );

renderer.gap(20);

renderer.render(
        new BandColumn(leftHalfPageField, "País:", "México"),
        new BandColumn(rightHalfPageField, "País:", "México")
        );

renderer.close();
document.save(new File(RESULT_FOLDER, "Endorsement.pdf"));