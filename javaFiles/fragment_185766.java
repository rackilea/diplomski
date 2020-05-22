private void findReplace(String a, String b, CustomXWPFDocument document){
    for (XWPFParagraph p : document.getParagraphs()) {
        List<XWPFRun> runs = p.getRuns();
        if (runs != null) {
            for (XWPFRun r : runs) {
                String text = r.getText(0);
                if (text != null && text.contains(a)) {
                    text = text.replace(a, b);
                    r.setText(text, 0);
                }
            }
        }
    }
}