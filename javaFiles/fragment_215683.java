public void wordDocProcessor(AnotherVO anotherData, ArrayList<String> list,
        String sourse, String destination) throws IOException,
        InvalidFormatException {
    XWPFDocument doc = new XWPFDocument(OPCPackage.open(sourse
            + "XXXXX_TestReport_URL_Document.doc"));
    for (XWPFTable tbl : doc.getTables()) {
        for (XWPFTableRow row : tbl.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
                for (XWPFParagraph p : cell.getParagraphs()) {
                    for (XWPFRun r : p.getRuns()) {
                        String text = r.getText(0);
                        if (text != null
                                && text.contains("var_source_code")) {
                            text = text.replace("var_source_code",
                                    list.get(1));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("var_rsvp_code")) {
                            text = text.replace("var_rsvp_code",
                                    list.get(2));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("var_ssn")) {
                            text = text.replace("var_ssn", list.get(3));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("var_zip_code")) {
                            text = text
                                    .replace("var_zip_code", list.get(4));
                            r.setText(text, 0);
                        }
                        if (text != null
                                && text.contains("var_point_for_business")) {
                            text = text.replace("var_point_for_business",
                                    anotherData.getPointForBusiness());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("var_E1_url")) {
                            text = text.replace("var_E1_url",
                                    anotherData.getE1url());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("var_E2_url")) {
                            text = text.replace("var_E2_url",
                                    anotherData.getE2url());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("var_E3_url")) {
                            text = text.replace("var_E3_url",
                                    anotherData.getE3url());
                            r.setText(text, 0);
                        }
                    }
                }
            }
        }
    }
    doc.write(new FileOutputStream(destination + list.get(0)
            + "_TestReport_URL_Document.doc"));
}