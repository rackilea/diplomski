void parseElement(XWPFDocument doc) {
    for (IBodyElement e : doc.getBodyElements()) {
        if (e instanceof XWPFParagraph) {
            XWPFParagraph p = (XWPFParagraph) e
            if (p.runs.embeddedPictures.flatten()) {
                p.runs.each { r ->
                    r.embeddedPictures.each { pic ->
                        XWPFParagraph p1 = document.createParagraph()
                        XWPFRun r1 = p1.createRun()
                        int width = pic.getCTPicture().getSpPr().getXfrm().getExt().getCx() as int
                        int height = pic.getCTPicture().getSpPr().getXfrm().getExt().getCy() as int
                        int imgFormat1 = getImageFormat(pic.pictureData.fileName)
                        r1.addPicture(new ByteArrayInputStream(pic.pictureData.data), imgFormat1, pic.pictureData.fileName, width, height)
                        i++
                    }
                }
            } else {
                if (p.getCTP().getPPr() != null && p.getCTP().getPPr().getSectPr() != null) {
                    continue
                } else {
                    document.createParagraph()
                    document.setParagraph(p, i)
                    i++
                }
            }
        } else if (e instanceof XWPFTable) {
            XWPFTable t = (XWPFTable) e
            document.createTable()
            document.setTable(j, t)
            j++
        }
    }
}