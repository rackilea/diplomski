import android.app.Service;
import android.content.Context;
import android.content.Intent;
 import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationServices;


import java.io.IOException;
import java.io.OutputStreamWriter;

public class GPSService extends Service implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,LocationListener {



private GoogleApiClient mGoogleApiClient;

private LocationRequest mLocationRequest;

@Nullable
@Override
public IBinder onBind(Intent intent) {
    return null;
}


@Override
public void onCreate() {
    super.onCreate();

    mGoogleApiClient = new GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build();

}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {

    mGoogleApiClient.connect();

    return super.onStartCommand(intent, flags, startId);
}

@Override
public void onDestroy() {


    mGoogleApiClient.disconnect();
    super.onDestroy();



}


@Override
public void onConnected(Bundle bundle) {
    mLocationRequest = LocationRequest.create();
    mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    mLocationRequest.setInterval(1000); // Update location every second

    LocationServices.FusedLocationApi.requestLocationUpdates(
            mGoogleApiClient, mLocationRequest, this);
}

@Override
public void onConnectionSuspended(int i) {
    Toast.makeText(this,"GoogleApiClient connection has been suspend",Toast.LENGTH_LONG).show();
}

@Override
public void onConnectionFailed(ConnectionResult connectionResult) {
    Toast.makeText(this,"GoogleApiClient connection has failed",Toast.LENGTH_LONG).show();
}