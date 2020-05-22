private Composite graphicalControl;

/*
 * (non-Javadoc)
 * 
 * @see
 * org.eclipse.gef.ui.parts.GraphicalEditor#createGraphicalViewer(org.eclipse
 * .swt.widgets.Composite)
 */
protected void createGraphicalViewer(Composite parent) {
    graphicalControl = new Composite(parent, SWT.None);
    graphicalControl.setLayout(new GridLayout());

    Label label = new Label(graphicalControl, SWT.None);
    label.setText("MY DIAGRAM NAME!!!");
    label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    rulerComp = new RulerComposite(graphicalControl, SWT.NONE);
    super.createGraphicalViewer(rulerComp);
    rulerComp
            .setGraphicalViewer((ScrollingGraphicalViewer) getGraphicalViewer());
    rulerComp.setLayoutData(new GridData(GridData.FILL_BOTH));
}

protected Control getGraphicalControl() {
    return graphicalControl;
}