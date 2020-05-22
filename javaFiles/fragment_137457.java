public abstract class TemplateFace {
    public abstract Layout generateFace();
    public abstract PopulateGridHandler createPopulateGridHandler();
    protected abstract class PopulateGridHandler implements ClickHandler{
        @Override
        public abstract void onClick(ClickEvent event); 
    }
}