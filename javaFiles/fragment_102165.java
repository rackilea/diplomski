grid.addListener(Events.CellDoubleClick, new Listener<GridEvent>() {
    public void handleEvent(GridEvent be) {
        // be.getColIndex() gets the index of the column clicked on.
        // if you know the index of `column`, you can compare that number to the colIndex
        // if the numbers are equal, do whatever you want to do
        // see docs for GridEvent at 
        // http://dev.sencha.com/deploy/gxt-2.2.5/docs/api/com/extjs/gxt/ui/client/event/GridEvent.html
    }
});