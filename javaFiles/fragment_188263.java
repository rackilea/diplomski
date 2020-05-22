XWPFDocument doc = new XWPFDocument(OPCPackage.open("myfile.docx"));
for (XWPFParagraph paragraph : doc.getParagraphs()) {
    int pos = 0;
    for (XWPFRun run : paragraph.getRuns()) {
        for (character c : run.text().toCharArray()) {
            System.out.println("The character at " + pos + " is " + c);
            pos++;
        }
    }
}