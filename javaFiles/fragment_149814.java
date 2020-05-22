for (int i = 0; i < 28; i++) {
        doc.add(new Paragraph("\n"));
    }

    Div div = new Div();
    div.add(new Paragraph("Please, keep me with the next element").setKeepWithNext(true));
    div.add(new Paragraph("I don't want to be alone!"));

    div.setKeepTogether(true);

    doc.add(div);