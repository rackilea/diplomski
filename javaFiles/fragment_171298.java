class ConnectedEdgeColorAction extends ColorAction {

    final int outgoing = ColorLib.rgb(255, 100, 100);
    final int incoming = ColorLib.rgb(100, 255, 100);
    final int none = ColorLib.gray(100);

    public ConnectedEdgeColorAction(String group, String field) {
        super(group, field);
    }

    @Override
    public int getColor(VisualItem item) {
        if (item instanceof EdgeItem) {
            if (((EdgeItem) item).getSourceItem().isHover()) {
                return outgoing;
            } else if (((EdgeItem) item).getTargetItem().isHover()) {
                return incoming;
            }
        }

        return none;
    }

}