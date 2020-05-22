add(new AjaxLazyLoadPanel("lazy") {
    @Override
    public Component getLazyLoadComponent(String id) {
        return new MyPanel(id);
    }
});