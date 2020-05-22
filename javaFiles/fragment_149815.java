for (int i = 0; i < 28; i++) {
        doc.add(new Paragraph("\n"));
    }

    doc.add(new Paragraph("Please, keep me with the next element").setKeepWithNext(true));
    doc.add(new Paragraph("I don't want to be alone!"));