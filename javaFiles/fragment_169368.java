String htmlString="<bold>Hi everyone</bolddd>, my name is <italic>Maurice</italic>";
     ArrayList p=new ArrayList();

     StringReader strReader = new StringReader(htmlString);
     Document document = new Document(PageSize.A4, 20, 20, 20, 50);
     PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("filename.pdf"));
     document.open();
     -------
     -------              
     p = HTMLWorker.parseToList(strReader, null);
     Paragraph paragraph=new paragraph();
     for (int k = 0; k < p.size(); ++k){
         paragraph.add((com.lowagie.text.Element)p.get(k));
     }
     document.add(paragraph);

     ------- 
     -------
     document.close();