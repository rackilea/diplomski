public class MyVisualizationViewer extends VisualizationViewer<GraphElements.MyVertex, GraphElements.MyEdge> {
    public MyVisualizationViewer() {
        super(new StaticLayout(new SparseMultigraph<GraphElements.MyVertex, GraphElements.MyEdge>()));
        this.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        this.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        // Create a graph mouse and add it to the visualization viewer
        EditingModalGraphMouse gm = new EditingModalGraphMouse(this.getRenderContext(),
                GraphElements.MyVertexFactory.getInstance(),
                GraphElements.MyEdgeFactory.getInstance());
        // Set some defaults for the Edges...
        GraphElements.MyEdgeFactory.setDefaultCapacity(10.0);
        GraphElements.MyEdgeFactory.setDefaultWeight(10.0);
//        // Trying out our new popup menu mouse plugin...
        PopupVertexEdgeMenuMousePlugin myPlugin = new PopupVertexEdgeMenuMousePlugin();
//        // Add some popup menus for the edges and vertices to our mouse plugin.
        JPopupMenu edgeMenu = new MyMouseMenus.EdgeMenu(frame);
        JPopupMenu vertexMenu = new MyMouseMenus.VertexMenu();
        myPlugin.setEdgePopup(edgeMenu);
        myPlugin.setVertexPopup(vertexMenu);
        gm.remove(gm.getPopupEditingPlugin());  // Removes the existing popup editing plugin
        gm.add(myPlugin);   // Add our new plugin to the mouse
        this.setGraphMouse(gm);
    }
}