public static class LimitedBoundedRangeModel extends DefaultBoundedRangeModel {

    BoundedRangeModel limit;

    public LimitedBoundedRangeModel(BoundedRangeModel limit) {
        this.limit = limit;
    }

    /** 
     * @inherited <p>
     */
    @Override
    public void setRangeProperties(int newValue, int newExtent, int newMin,
            int newMax, boolean adjusting) {
        if (limit != null) {
            int combined = newValue + limit.getValue();
            if (combined > newMax) {
                newValue = newMax - limit.getValue();
            }
        }
        super.setRangeProperties(newValue, newExtent, newMin, newMax, adjusting);
    }
}

// use
LimitedBoundedRangeModel firstModel = new LimitedBoundedRangeModel(null);
LimitedBoundedRangeModel secondModel = new LimitedBoundedRangeModel(firstModel);
firstModel.limit= secondModel;

JSlider first = new JSlider(firstModel);
JSlider second = new JSlider(secondModel);