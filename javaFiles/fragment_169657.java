RendererClickListener clickListener = new RendererClickListener() {
    private static final long serialVersionUID = 1L;

    @Override
    public void click(RendererClickEvent event) {
        //Do your actions
    }
};
ButtonRenderer renderer = new ButtonRenderer(ownerClickListener, "");
grid.getColumn("columnName").setRenderer(renderer);