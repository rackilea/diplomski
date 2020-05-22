mxGraph graph = new mxGraph()
{
  // Make all edges unmovable
  public boolean isCellMovable(Object cell)
  {
    return !getModel().isEdge(cell);
  }

  // Make all vertex boxes unresizable
  public boolean isCellResizable(Object cell)
  {
     return !getModel().isVertex(cell);
  }
};

// Make all vertices and edges uneditable
graph.setCellsEditable(false);

// Make all edges unbendable
graph.setCellsBendable(false);

// Get the selected vertex or edge
System.out.println(graph.getSelectionCell());

// To insert a vertex with a given color:
Object v1 = graph.insertVertex(parent, null, "Hello",
            20, 20, 80, 30, "fillColor=#FF0000;");

// To modify the color of a vertex:
graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "#00FF00", new Object[]{v1});