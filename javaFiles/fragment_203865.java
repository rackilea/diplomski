table.addRangeChangeHandler(new RangeChangeEvent.Handler() {
    @Override
    public void onRangeChange(RangeChangeEvent event) {
        int start = event.getNewRange().getStart();
        int length = event.getNewRange().getLength();
        // get data from REST service
    }
});