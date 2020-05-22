vehicleBrandCol.setCellFactory(column->{
            return new TableCell<Person, ArrayList<Car>>() {
                @Override
                protected void updateItem(ArrayList<Car> item, boolean empty) {
                    super.updateItem(item, empty);
                    if(item==null || empty) {
                        setGraphic(null);
                    } else {
                        VBox vbox = new VBox();
                        for(Car car : item) {
                            Label lbl = new Label(car.getBrand());
                            vbox.getChildren().add(lbl);
                        }
                        setGraphic(vbox);
                    }
                }
            };
        });