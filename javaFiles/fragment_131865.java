private void doSaveAs() throws IOException {
    // instantiate and configure image-able visualization viewer
    VisualizationImageServer<Vertex, Edge> vis =
            new VisualizationImageServer<Vertex, Edge>(this.visViewer.getGraphLayout(),
                                                       this.visViewer.getGraphLayout().getSize());

    setUpAppearance(vis);

    ExportDialog export = new ExportDialog();
    export.showExportDialog(vis, "Export view as ...", vis, "export");
}