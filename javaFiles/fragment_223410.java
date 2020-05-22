public void init() {
    canvas = new JSVGCanvas(null, true, false);
    canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
}

public void paint(final DomainObject domainObject) {
    canvas.addGVTTreeRendererListener(new GVTTreeRendererAdapter() {
        public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
            renderComplete(domainObject);
        }
    });
}

public void renderComplete(DomainObject domainObject) {
    UpdateManager updateManager = canvas.getUpdateManager();
    RunnableQueue runnableQueue = updateManager.getUpdateRunnableQueue();
    runnableQueue.invokeLater(new Runnable() {
        public void run() {
            // Document operations here
        }
    });
}