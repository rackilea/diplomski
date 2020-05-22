public void start(Stage primaryStage) throws Exception {

                ObservableList<String> cities = FXCollections.observableArrayList();
                ComboBox<String> country = new ComboBox<String>(cities);

                String[] locales1 = Locale.getISOCountries();
                for (String countrylist : locales1) {
                    Locale obj = new Locale("", countrylist);
                    String[] city = { obj.getDisplayCountry() };
                    for (int x = 0; x < city.length; x++) {
                        cities.add(obj.getDisplayCountry());
                    }
                }
                country.setItems(cities);
 }