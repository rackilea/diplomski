MyBoundedRangeModel boundedRangeModel = new MyBoundedRangeModel();
slider.setModel(boundedRangeModel);

...

boundedRangeModel.setUpdatesAllowed(true);
slider.setValue(value);
boundedRangeModel.setUpdatesAllowed(false);