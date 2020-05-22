public class mxGraphExtended extends mxGraph {

    @Override
    public void drawCell(mxICanvas canvas, Object cell) {
        // add the cell's id as a style attribute
        // cause canvas only get the style and geometry
        mxCellState state = this.getView().getState(cell);
        state.getStyle().put("cellid", ((mxCell)cell).getId());

        super.drawCell(canvas, cell);
    }
}