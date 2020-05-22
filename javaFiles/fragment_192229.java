private class FetchWeatherTask extends AsyncTask<Object, Void, Void> {

    @Override
    protected void doInBackground(Object... params) {

        String postalCode = (String) params[0];
        String countryCode = (String) params[1];
        // if you also want to pass third value in type int it should be like
        //int thirdValue = (Integer) params[3]
    }
    ...
}