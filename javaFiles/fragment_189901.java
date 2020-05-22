public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    LayoutInflater inflater = LayoutInflater.from(getActivity());
    LinearLayout linearLayout = (LinearLayout) getView();
    if(linearLayout != null)
        linearLayout.removeAllViewsInLayout();

    // Checks the orientation of the screen
    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        ViewGroup parentViewGroup = (ViewGroup)chart.getChart().getParent();
        if (parentViewGroup != null)
            parentViewGroup.removeView(chart.getChart());

        fragmentRootContainer = inflater.inflate(R.layout.activity_exam, linearLayout, true);
        LineChart lineChart = (LineChart) fragmentRootContainer.findViewById(R.id.chart);
        lineChart.addView(chart.getChart());
    }
    else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

        ViewGroup parentViewGroup = (ViewGroup)chart.getChart().getParent();
        if (parentViewGroup != null)
            parentViewGroup.removeView(chart.getChart());

        fragmentRootContainer = inflater.inflate(R.layout.activity_exam, linearLayout, true);
        inflater.inflate(R.layout.activity_exam, linearLayout, false);

        LineChart lineChart = (LineChart) fragmentRootContainer.findViewById(R.id.chart);
        lineChart.addView(chart.getChart());
    }
}