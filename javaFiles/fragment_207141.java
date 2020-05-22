void removeInterpolation( int pageNum ) {
  PdfDictionary page = someReader.getPageN(pageNum);
  PdfDictionary resources = page.getAsDict(PdfName.RESOURCES);

  enumResources(resources);
}

void enumResource( PdfDictionary resources) {
  PdfDictionary xobjs = resources.getAsDict(PdfName.XOBJECTS);

  Set<PdfName> xobjNames = xobjs.getKeys();
  for (PdfName name : xobjNames) {

    PdfStream xobjStream = xobjs.getAsStream(name);

    if (PdfName.FORM.equals( xobjStream.getAsName(PdfName.SUBTYPE))) {
      // xobject forms have their own nested resources.
      PdfDictionary nestedResources = xobjStream.getAsDict(PdfName.RESOURCES);
      enumResources(nestedResources);
    } else {
      xobjStream.remove(PdfName.INTERPOLATE);
    }
  }
}