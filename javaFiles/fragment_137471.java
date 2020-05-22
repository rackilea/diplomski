private static final Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(... your service URL here ...)
        .addConverterFactory(new Converter.Factory() {
            @Override
            public Converter<?, String> stringConverter(final Type type, final Annotation[] annotations, final Retrofit retrofit) {
                // Is it LanLng from the above?
                if ( !type.equals(LatLng.class) ) {
                    // No, let Retrofit manage this itself
                    return super.stringConverter(type, annotations, retrofit);
                }
                // We can convert it ourselves by creating a custom converter from LatLng to String
                // (No worries about + -- javac should be smart enough to use StringBuilder here)
                return (Converter<LatLng, String>) latLng -> latLng.latitude + "," + latLng.longitude;
            }
        })
        .addConverterFactory(... your basic message converter here ...)
        .build();