double current = 0.0;
double min = (double) Integer.MIN_VALUE;
double max = (double) Integer.MAX_VALUE;
double step = 0.1;

JSpinner mySpinnerExample = new JSpinner(new SpinnerNumberModel(current, min, max, step))