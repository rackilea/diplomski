public class AirportApi {
    public Single<AirportCodes> getAirports(@Body...);
}

public class AirportDisplayActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AirportApi.Factory.getInstance()
            .getAirports(requestBody)
            .subscribe(
                onSuccess = {...},
                onError = {...}
            );
    }
}