public interface ApiInterface {

    // public API key
    @GET("api/etd.aspx?cmd=etd&key=MW9S-E7SL-26DU-VV8V&orig=ANTC&json=y")
    Call<TrainArrival> getData();
}