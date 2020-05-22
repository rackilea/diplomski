Options options = AreaChart.createOptions();
AxisOptions verticalOptions = AxisOptions.create();
verticalOptions.setDirection(-1);
options.setVAxisOptions(verticalOptions);
...
... 
AreaChart area = new AreaChart(data, options);