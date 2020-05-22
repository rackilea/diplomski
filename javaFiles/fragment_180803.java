for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                if (text != null && text.contains("$$key$$")) {
                                    text = text.replace("<asdas>", "abcd");
                                    r.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }