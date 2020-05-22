// this value must be final in order to be visible to the anonymous inner class instance
            // of Format below.  Note that this will fail miserably if you try to plot a series of
            // size < 2.
            final double firstX = Math.round(((Number) series.getX(0)).doubleValue());
            double secondX = Math.round(((Number) series.getX(1)).doubleValue());
            double lastX = Math.round(((Number) series.getX(series.size() - 1)).doubleValue());

            // assuming the step interval is uniform, this is the distance between each xVal:
            double stepInterval = secondX - firstX;

            // add in extra space for the first "invisible index" by setting the starting
            // domain boundary exactly one interval before the first actual element:
            plot.setDomainBoundaries(firstX - stepInterval, lastX, BoundaryMode.FIXED);

            // add an extra "invisible index":
            plot.setDomainStep(StepMode.SUBDIVIDE,dates.size() + 1);

            ...

            plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {

                @Override
                public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                    double timestampMs = Math.round(((Number) obj).doubleValue());

                    // only render indices corresponding to values in the series:
                    if(timestampMs >= firstX) {
                        Date date_Label = new Date();
                        return format.format(date_Label, toAppendTo, pos);
                    }
                }

                @Override
                public Object parseObject(String source, ParsePosition pos) {
                    return null;
                }
            });