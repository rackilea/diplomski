private void PdfToImage(String PDFFILE){
            try{

                PDDocument document = PDDocument.load(new File(PDFFILE));
                PDPage pd;

                PDFRenderer pdfRenderer = new PDFRenderer(document);
                for (int page = 0; page < document.getNumberOfPages(); ++page)
                {


                  pd = document.getPage(page);
                  pd.setCropBox(new PDRectangle(100, 100,100,100));
                  BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                  ImageIOUtil.writeImage(bim, outputpath + (page+1) + ".png", 300);

                }
                document.close();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getStackTrace());
            }
        }