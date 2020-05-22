routeColorCol.setCellFactory(
    TextFieldTableCell.<Foo, Color> forTableColumn(new StringConverter<Color>() {
        @Override
        public String toString(Color object) {
            return object != null ? object.toString() : "";
        }

        @Override
        public Color fromString(String string) {
            return Color.valueOf(string);
        }
    }
));