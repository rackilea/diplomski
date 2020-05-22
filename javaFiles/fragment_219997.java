vehicleBrandCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person,String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Person, String> param) {
                ArrayList<Car> cars = new ArrayList<Car>();
                cars = param.getValue().getCars();
                if(cars!=null && !cars.isEmpty()) {
                    return new SimpleStringProperty(cars.get(0).getBrand());
                }
            }
        }
);