private Series<Number, Number> createSeries(String name, double[][] values) {
        Series<Number, Number> series = new Series<>();
        ObservableList<Data<Number, Number>> data = FXCollections.observableArrayList(
            d -> new Observable[] {d.XValueProperty(), d.YValueProperty()});

        for (double[] point : values) {
            series.getData().add(new Data<>(point[0],point[1]));
        }

        series.nameProperty().bind(Bindings.createStringBinding(() -> 
            String.format("%s (r=%.3f)", name, computeCorrelation(data)),
            data);

        return series ;
    }   

    private double computeCorrelation(List<Data<Number, Number>> data) {
        //TODO compute correlation from data...
        return 0 ;
    }