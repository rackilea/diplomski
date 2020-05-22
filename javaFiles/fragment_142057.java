@Override
public void processUpdates(FacesContext context) {
    super.processUpdates(context);

    ValueExpression selectionVE = this.getValueExpression("selection");

    if(selectionVE != null) {
        selectionVE.setValue(context.getELContext(), this.getLocalSelection());

        this.setSelection(null);
    }