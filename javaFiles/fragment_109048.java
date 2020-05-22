public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    //recuperer les parametrse envoyés
    String code=request.getParameter("cc");
    String client=request.getParameter("clt");
    String produit=request.getParameter("pdt");
    String quantite=request.getParameter("qc");
    String prixT=request.getParameter("px");

    response.setContentType("application/pdf");

    try{
    Document doc1 = new Document();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PdfWriter.getInstance(doc1, baos);

    doc1.addAuthor("Asuce Tech");
    doc1.addTitle("Facture de la commande ajoutée");

    doc1.open();

    //ajouter du style au PDF
    Chunk chunk = new Chunk("Facture");
    Font font = new Font(Font.COURIER);
    font.setStyle(Font.UNDERLINE);
    font.setStyle(Font.ITALIC);
    chunk.setFont(font);
    chunk.setBackground(Color.CYAN);
    doc1.add(chunk);

    Paragraph paragraph = new Paragraph();
    paragraph.add("Gestion Commercial par point de vente");
    paragraph.setAlignment(Element.ALIGN_CENTER);
    paragraph.setAlignment(Element.ALIGN_CENTER);
    doc1.add(paragraph);
    doc1.add(new Paragraph("Facture générée Le "+ new java.util.Date()));
    List list = new List(true, 15);
    list.add("Code Commande : "+code);
    list.add("Nom Client    : "+client);
    list.add("Nom Produit   : "+produit);
    list.add("Quantité commandée : "+quantite);
    list.add("Prix Total    : "+prixT);
    doc1.add(list);

        doc1.close();

        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Content-disposition",
                "inline; filename=factureCommande.pdf" );
        response.setHeader("Pragma", "public");
            // setting the content type


    response.setContentLength(baos.size());

    ServletOutputStream sos;
    sos = response.getOutputStream();
    baos.writeTo(sos);
    sos.flush();
    }
    catch(DocumentException e) {
        throw new IOException(e.getMessage());
    }
}