for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("$$key$$")) {
                            text = text.replace("<asdas>", "ABCD");// your content
                            r.setText(text, 0);
                        }
                    }
                }
            }