// use the extended svg canvas, where the cell id is added as attribute
public void createSVG(mxGraphExtended g) {
  String filename = "\home\koula\graph.svg";
  mxSvgCanvasExtended canvas = (mxSvgCanvasExtended) mxCellRenderer.drawCells(
    g, null, 1, null, new CanvasFactory() {
    public mxICanvas createCanvas(int width, int height) {
        mxSvgCanvasExtended canvas = new mxSvgCanvasExtended(mxDomUtils
            .createSvgDocument(width, height));
            canvas.setEmbedded(true);
            return canvas;
        } 
    });
  try {
    mxUtils.writeFile(mxXmlUtils.getXml(canvas.getDocument()), filename);
  } catch (IOException e) {
    e.printStackTrace();
  } 
}