document.open();

    // the same contentByte is returned, it's just flushed & reset during
    // new page events.
    PdfContentByte cb = writer.getDirectContent();

    for (int _pageNumber = 0; _pageNumber < _numberofPages; ++_numberOfPages) {
      /*******************/
      //harmless in first pass, *necessary* in others
      document.newPage(); 
      /*******************/

      g2 = cb.createGraphics(_pageWidth, _height);
      g2.translate(0, (_numberOfPages - _pageNumber) * _pageHeight);
      draw(g2);
      g2.dispose();
    }

    document.close();