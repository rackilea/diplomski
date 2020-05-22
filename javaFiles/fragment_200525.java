View v = inflate(getContext(), R.layout.line_chart_recyclerview, null);

    LineChart.LayoutParams params = new LineChart.LayoutParams(
        getWidth() / 2, getHeight());
    params.addRule(LineChart.ALIGN_PARENT_RIGHT);
    addView(v, params);