public static class MyComboBox<T> extends ComboBox {
    private CaptionComposer captionComposer;

    public MyComboBox(CaptionComposer<T> captionGenerator, BeanItemContainer<T> dataSource) {
        this.captionComposer = captionGenerator;
        setContainerDataSource(dataSource);
    }

    @Override
    public String getItemCaption(Object itemId) {
        return captionComposer.getCaption(itemId);
    }
}