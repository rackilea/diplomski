yAxis.setTickLabelFormatter(new StringConverter<Number>() {

            @Override
            public String toString(Number object) {
                return String.format("%.1f", object.doubleValue());
            }

            @Override
            public Number fromString(String string) {
                return new Double(string);
            }

        });