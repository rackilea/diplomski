/**
 * Represents a geographical location.
 */
protected Location mLastLocation;

@Override
public void onConnected(Bundle connectionHint) {
     // Gets the best and most recent location currently available, which may be null
     // in rare cases when a location is not available.
     mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
     if (mLastLocation != null) {
         // Determine whether a Geocoder is available.
         if (!Geocoder.isPresent()) {
             Toast.makeText(this, "no geocoder available", Toast.LENGTH_LONG).show();
             return;
         }
     }
 }