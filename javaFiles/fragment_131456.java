ResultSet rs = ps.executeQuery();

while (rs.next()) {
     String name = rs.getString(1);
     Double no = rs.getDouble(2);
     XYChart.Series<String, Double> series = new XYChart.Series<>();
     series.getData().add(new XYChart.Data<>(name, no));
     barchart1.getData().add(new XYChart.Data<>);
}