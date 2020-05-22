class Canvas extends JSVGCanvas implements SVGLoadEventDispatcherListener {

    public Canvas() {
        super();
        setDocumentState(ALWAYS_DYNAMIC);
        addSVGLoadEventDispatcherListener(this);
    }

    /**
     * Indicatates whether the canvas has finished its first render, the
     * canvas is now ready for modification of the dom
     */
    private boolean isReadyForModification = false;

    /**
     * Renew the document by replacing the root node with the one of the new
     * document
     * 
     * @param doc The new document
     */
    public void renewDocument(final SVGDocument doc) {

        if (isReadyForModification) {
            getUpdateManager().getUpdateRunnableQueue().invokeLater(
                    new Runnable() {
                        @Override
                        public void run() {
                            // Get the root tags of the documents
                            Node oldRoot = getSVGDocument().getFirstChild();
                            Node newRoot = doc.getFirstChild();

                            // Make the new node suitable for the old
                            // document
                            newRoot = getSVGDocument().importNode(newRoot,
                                    true);

                            // Replace the nodes
                            getSVGDocument().replaceChild(newRoot, oldRoot);
                        }
                    });
        } else {
            setSVGDocument(doc);
        }

    }

    @Override
    public void svgLoadEventDispatchCompleted(SVGLoadEventDispatcherEvent e) {
        isReadyForModification = true;
    }

    // ...
}