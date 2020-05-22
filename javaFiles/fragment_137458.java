public class AdminFace extends TemplateFace{
    private ListGrid adminListGrid;
    public Layout generateFace() {
        adminListGrid = GridBuilder.buildFullGrid(this);       
    }
    public PopulateGridHandler createPopulateGridHandler() {
        return new MyPopulateGridHandler();
    }
    private class MyPopulateGridHandler extends PopulateGridHandler {
        @Override
        public void onClick(ClickEvent event) { // some implementations ... }
    }
}