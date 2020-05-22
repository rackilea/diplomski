@Override
            public WeatherData createFromParcel(Parcel source) {
                // read the bundle containing key value pairs from the parcel
                Bundle bundle = source.readBundle();
                bundle.setClassLoader(ForecastInfo.class.getClassLoader());
                // instantiate the weather using values from the bundle
bundle.getParcelable("forecastList"));
                return new WeatherData(bundle.getString("cityName"),
                        new ArrayList<ForecastInfo>());

            }