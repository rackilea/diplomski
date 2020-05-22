public class AirportApi {
    public Call<AirportCodes> getAirports(@Body...);
}

public class NearestAirports {
    public List<GeoSearchResult> listNearestAirports(String lat, String lng) {
        final Response<AirportCodes> airportCodes = AirportApi.Factory.getInstance()
            .getAirports(requestBody)
            .execute();

        // interrogate response and transform AirportCodes into List<GeoSearchResult>
        // don't forget to account for failures
}