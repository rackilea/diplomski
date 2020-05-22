int maxValue = ...    // here, you find your max value
  // search the interval between 2 vertical labels
  int interval;
  if (maxValue <= 55) {
      interval = 5; // increment of 5 between each label
  } else if (maxValue <= 110) {
      interval = 10; // increment of 10 between each label
  } else {
      interval = 20; // increment of 20 between each label
  }
  // search the top value of your graph, it must be a multiplier of your interval
  int maxLabel = maxValue;
  while (maxLabel % interval != 0) {
      maxLabel++;
  }
  // set manual bounds
  setManualYAxisBounds(maxLabel, 0);
  // indicate number of vertical labels
  getGraphViewStyle().setNumVerticalLabels(maxLabel / interval + 1);
  // now, it's ok, you should have a graph with integer labels