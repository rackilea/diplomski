scroll1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
       scroll2.getVerticalScrollBar().setValue(e.getValue());
    }
});