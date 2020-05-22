StringConverter<Double> converter = new StringConverter<Double>() {

            @Override
            public String toString(Double number) {
                return df.format(number);
            }

            @Override
            public Double fromString(String string) {
                try {
                    double value = df.parse(string).doubleValue() ;
                    return value;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0.0 ;
                }
            }

        };

        textFormatter = new TextFormatter<>(converter,  0.0, c -> {
            if (partialInputPattern.matcher(c.getControlNewText()).matches()) {
                return c ;
            } else {
                return null ;
            }
        }) ;