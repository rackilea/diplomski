else {
    JScrollBar horizBar = scroller2.getHorizontalScrollBar();
    DefaultBoundedRangeModel currentModel = (DefaultBoundedRangeModel) horizBar.getModel();
    int extent = currentModel.getExtent();
    int min = currentModel.getMin();
    int max = currentModel.getMax();
    int value = currentModel.getValue();

    DefaultBoundedRangeModel newModel = new DefaultBoundedRangeModel(value, extent, min, max);
    horizBar.setModel(newModel);
}