Paragraph p = new Paragraph("some longer text some longer text some longer text");
p.setWidth(100);

// Create renderer tree
IRenderer paragraphRenderer = p.createRendererSubTree();
// Do not forget setParent(). Set the dimensions of the viewport as needed
LayoutResult result = paragraphRenderer.setParent(document.getRenderer()).
                        layout(new LayoutContext(new LayoutArea(1, new Rectangle(100, 1000))));

// LayoutResult#getOccupiedArea() contains the information you need
System.out.println("height " + result.getOccupiedArea().getBBox().getHeight());