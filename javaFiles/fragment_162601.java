try {

    FileInputStream fis = new FileInputStream("C:\\sample\\sample.pptx");
    XMLSlideShow pptxshow = new XMLSlideShow(fis);

    XSLFSlide[] slide2 = pptxshow.getSlides();
    for (int i = 0; i < slide2.length; i++) {
        System.out.println(i);
        try {
            XSLFNotes mynotes = slide2[i].getNotes();
            for (XSLFShape shape : mynotes) {
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape txShape = (XSLFTextShape) shape;
                    for (XSLFTextParagraph xslfParagraph : txShape.getTextParagraphs()) {
                        System.out.println(xslfParagraph.getText());
                    }
                }
            }
        } catch (Exception e) {

        }

    }
} catch (IOException e) {

}