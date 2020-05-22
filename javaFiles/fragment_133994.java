public static void writeDocFile(List<String> paras) {
    XWPFDocument document = null;
    try {
        document = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(new File("matchedpara.docx"));
        for (String para : paras) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setSpacingAfter(1);
            paragraph.createRun().setText(para);
        }
        document.write(out);
        out.close();
        System.out.println("matchedpara.docx written successfully");
    } catch (Exception er) {
        er.printStackTrace();
    }
    finally {
        try {
            if (document != null) {
                document.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}