byte[] pptxpic = null;

ChartUtilities.saveChartAsPNG(pngfile, chart, 1000, 800);

pptxpic = IOUtils.toByteArray(new FileInputStream(pngfile));

int idx = pptxTemplate.addPicture(pptxpic,
                XSLFPictureData.PICTURE_TYPE_PNG);
XSLFPictureShape pic = slidedips.createPicture(idx);

pic.setAnchor(new java.awt.Rectangle(0, 60, 960, 630));