if (dataSnapshot.exists()) {
       Integer total = dataSnapshot.getValue(Integer.class);
       total_to = total;

       Pie pie = AnyChart.pie();
       List<DataEntry> data = new ArrayList<>();
       data.add(new ValueDataEntry("y", total_to) );
       data.add(new ValueDataEntry("x", 7) );
       pie.data(data);
       AnyChartView anyChartView = (AnyChartView)findViewById(R.id.piechart);
       anyChartView.setChart(pie);
}