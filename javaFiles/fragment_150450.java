public void createPdf(File sourceFile, String dest) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

        Document document = new Document(pdf);
        document.setTextAlignment(TextAlignment.LEFT);
        document.setFontSize((float) 8.0);
        document.setLeftMargin((float) 40.0);
        document.setRightMargin((float) 40.0);

        //BufferedReader br = new BufferedReader(new FileReader(sourceFile));
        BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream(sourceFile), "UTF8"));
        String line;
        PdfFont normal = PdfFontFactory.createFont(FontConstants.COURIER);
        Paragraph para = new Paragraph();
        para.setFont(normal);
        while ((line = br.readLine()) != null) {
            line = line.replace("\u0020", "\u00A0");
            para.add(line + "\n");
            //document.add(new Paragraph(line).setFont(normal));    
        }
        document.add(para);
        document.close();
        br.close();
    }