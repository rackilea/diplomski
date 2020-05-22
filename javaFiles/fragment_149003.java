final FlowPanel chartPanel = new FlowPanel();
flowpanel.add(chartPanel);

chartLoader.loadApi(new Runnable() {
    @Override
    public void run() {
        ...
        chartPanel.add(**YOUR CHART HERE**);
    }
});

flowpanel.add(**SOME OTHER CONTENT**);