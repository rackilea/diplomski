public void handleEvent (Event evt) {
    setRB(this.IDButtonGroup, this.ID);
    Element r = ((SVGDocument) doc).createElementNS(SVGNS,"use");
    r.setAttributeNS(XLINKNS, "href", "#cell");
    doc.getDocumentElement().appendChild(r);
}