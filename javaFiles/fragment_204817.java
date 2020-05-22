PdfContentByte over = stamper.getOverContent(i);
 Phrase p = new Phrase("WATERMARK");
 PdfGState gs = new PdfGState();
 gs.setFillOpacity(0.5f);
 over.setGState(gs);
 ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, 330, 450, 45);
 over.saveState();