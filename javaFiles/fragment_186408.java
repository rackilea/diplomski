import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.app1.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class LocationPicker extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker markerLocation;
    private GoogleApiClient mGoogleApiClient;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;
    double a,b;
    Place place;
    LatLng finalLocation;

    private LatLngBounds.Builder mBounds = new LatLngBounds.Builder();

    private void addPointToViewPort(LatLng newPoint) {
        mBounds.include(newPoint);
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(mBounds.build(),
                findViewById(R.id.addressTextView).getHeight()));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                place = PlacePicker.getPlace(this, data);

                PlaceAutocomplete.getPlace(this,data);
            } else if (resultCode == PlacePicker.RESULT_ERROR) {
                Toast.makeText(this, "Places API failure! Check that the API is enabled for your key",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        try {
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY).build(this);
            startActivityForResult(intent,1);
        }
        catch (GooglePlayServicesRepairableException e){
        }
        catch (GooglePlayServicesNotAvailableException e){
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_picker);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Places.GEO_DATA_API)
                .build();
        mGoogleApiClient.connect();

        View locationButton = ((View) findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
// position on right bottom
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        rlp.setMargins(0, 1500, 30, 20);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        //Task<AutocompletePredictionBufferResponse> results=Places.GeoDataApi.getAutocompletePredictions()
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place2) {
               place=place2;
               finalLocation=place2.getLatLng();
               mMap.moveCamera(CameraUpdateFactory.newLatLng(place2.getLatLng()));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(17));
                try{
                    mMap.setMyLocationEnabled(true);
                }
                catch(SecurityException e){

                }
                // TODO: Get info about the selected place.
                //Log.i(TAG, "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                //Log.i(TAG, "An error occurred: " + status);
            }
        });

        Button locationSetButton=(Button)findViewById(R.id.locationSetButton);
        locationSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng msd=finalLocation;
                //getCallingActivity();
                Geocoder geocoder=new Geocoder(LocationPickerActivity.this, Locale.getDefault());
                List<Address> nearByList=null;
                try {
                    nearByList = geocoder.getFromLocation(finalLocation.latitude,finalLocation.longitude , 1);
                }
                catch (IOException e){

                }
                Intent intent=new Intent();
                double[] geoCoordinates=new double[2];
                geoCoordinates[0]=msd.latitude;
                geoCoordinates[1]=msd.longitude;

                JSONObject userJSONObject=new JSONObject();
                JSONArray userJSONArray=new JSONArray();
                try {
                    Geocoder geocoder2=new Geocoder(LocationPickerActivity.this, Locale.getDefault());
                    List<Address> nearByList2=null;
                    HashSet<String> ls2=new HashSet<String>();
                    try {
                        nearByList = geocoder.getFromLocation(msd.latitude, msd.longitude, 1);
                    }
                    catch (IOException e){

                    }
                    Address ad2=nearByList.get(0);
                    ls2.add(ad2.getPostalCode());

                    DecimalFormat decimalFormat=new DecimalFormat("#.#####");
                    double x=Double.parseDouble(decimalFormat.format(msd.latitude));
                    double y=Double.parseDouble(decimalFormat.format(msd.longitude));
                    userJSONObject.put("Latitude", x);
                    userJSONObject.put("Longitude", y);
                    userJSONObject.put("GoogleAddressLine",ad2.getAddressLine(0));
                    userJSONObject.put("zipCode",ad2.getPostalCode());
                    userJSONObject.put("city",ad2.getLocality());
                    userJSONObject.put("state",ad2.getAdminArea());
                    userJSONObject.put("country",ad2.getCountryName());
                }
                catch (JSONException e){

                }
                userJSONArray.put(userJSONObject);
                String data=userJSONObject.toString();

                String loc=String.valueOf(geoCoordinates[0])+" * "+String.valueOf(geoCoordinates[1]);
                intent.putExtra("locationCoordinates",geoCoordinates);

                File locationFile=new File(getApplicationContext().getFilesDir(),"localLocationFile.txt");
                try {
                    FileOutputStream fos = new FileOutputStream(locationFile);
                    fos.write(data.getBytes());
                    fos.close();
                }
                catch (IOException e){

                }
                finish();
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        final TextView textView=(TextView)findViewById(R.id.addressTextView);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        mMap.setPadding(0, textView.getHeight(), 0, 0);
                    }
                }
        );

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                finalLocation=latLng;
                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.position(latLng);
                mMap.clear();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                mMap.addMarker(markerOptions);
            }
        });

        mFusedLocationClient= LocationServices.getFusedLocationProviderClient(this);
        mLocationRequest=new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);


        mLocationCallback=new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult)
            {
                if(locationResult==null){
                    return;
                }
                for(Location location : locationResult.getLocations())
                {
                    a=location.getLatitude();
                    b=location.getLongitude();
                    LatLng ll=new LatLng(a,b);
                    finalLocation=ll;
                    addPointToViewPort(ll);

                    markerLocation=mMap.addMarker(new MarkerOptions().position(ll).draggable(true));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(17));
                    try{
                    mMap.setMyLocationEnabled(true);
                    }
                    catch(SecurityException e){

                    }

                    Geocoder geocoder=new Geocoder(LocationPickerActivity.this, Locale.getDefault());
                    List<Address> nearByList=null;
                    HashSet<String> ls=new HashSet<String>();
                    try {
                        nearByList = geocoder.getFromLocation(a, b, 1);
                    }
                    catch (IOException e){

                    }
                    Address ad=nearByList.get(0);
                    ls.add(ad.getPostalCode());
                }
            }
        };

        try {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
        }
        catch (SecurityException e){

        }

    }
}