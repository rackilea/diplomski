Document source = new Document(MyDir + "template.doc");
Document target = new Document(MyDir + "target.doc");

StyleCollection sourceStyles = source.getStyles();
StyleCollection targetStyles = target.getStyles();

System.out.println("SORGENTE = " + sourceStyles.getCount() + " stili");
System.out.println("DESTINAZIONE = " + targetStyles.getCount() + " stili");

for (Style style : sourceStyles) {
    String name = style.getName();
    if (name.endsWith("Carattere")) continue;

    if (style.getType() == StyleType.PARAGRAPH
                            || style.getType() == StyleType.TABLE)
    {
        Style copied = targetStyles.addCopy(style);
        copied.setBaseStyleName(style.getBaseStyleName());

        if (style.getType() == StyleType.PARAGRAPH) {
           copied.setNextParagraphStyleName(style.getNextParagraphStyleName());
        }
        copied.setName(name);
        System.out.println("COPIA STILE " + name + " -> " + copied.getName());
    }
}

target.cleanup();
target.save(MyDir + "output.docx");