public class LocationReceiver extends BroadcastReceiver {

double latitude, longitude;

@Override
public void onReceive(final Context context, final Intent calledIntent)
{
    Log.d("LOC_RECEIVER", "Location RECEIVED!");

    latitude = calledIntent.getDoubleExtra("latitude", -1);
    longitude = calledIntent.getDoubleExtra("longitude", -1);

    updateRemote(latitude, longitude,biker_id);

}

private void updateRemote(final double latitude, final double longitude ,final String id)
{
    //HERE YOU CAN PUT YOUR ASYNCTASK TO UPDATE THE LOCATION ON YOUR SERVER
    String latitude_s=Double.toString(latitude);
    String longitude_s=Double.toString(longitude);
    new SendToServer().execute(longitude_s, latitude_s,id);
}