@Override
    public ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
        ISourceViewer viewer = super.createSourceViewer(parent, ruler, styles);

        if(viewer instanceof ITextViewerExtension) {
            ((ITextViewerExtension) viewer).appendVerifyKeyListener(<Listener>);
        }

        return viewer;
    }