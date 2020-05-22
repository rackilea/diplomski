dayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.updateChart(chartView, c, "area", "DataSteps.json", "day");
                chartView.reload();
            }
        });
        weekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.updateChart(chartView, c, "area", "DataSteps.json", "week");
                chartView.reload();
            }
        });
        monthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.updateChart(chartView, c, "area", "DataSteps.json", "month");
                chartView.reload();
            }
        });
        yearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.updateChart(chartView, c, "area", "DataSteps.json", "year");
                chartView.reload();
            }
        });