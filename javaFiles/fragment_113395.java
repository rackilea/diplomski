FontMapper arialuni = new FontMapper() {
            public BaseFont awtToPdf(Font font) {
                try {
                    return BaseFont.createFont(
                            "c:/windows/fonts/arialuni.ttf",
                            BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            public Font pdfToAwt(BaseFont font, int size) {
                return null;
            }

        };