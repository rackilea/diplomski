citiesList.setCellFactory(lv -> {
    TextFieldListCell<City> cell = new TextFieldListCell<City>();
    StringConverter<City> converter = new StringConverter<City>() {

        @Override
        public String toString(City city) {
            return city.getName();
        }

        @Override
        public City fromString(String string) {
            City city = cell.getItem();
            if (city == null) {
                City newCity = new City();
                newCity.setName(string);
                return newCity;
            } else {
                city.setName(string);
                return city ;
            }
        }

    };

    cell.setConverter(converter);

    return cell ;
});