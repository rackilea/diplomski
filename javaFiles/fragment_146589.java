package com.example.poly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, SeekBar.OnSeekBarChangeListener {
    //Initialise variables
    GoogleMap gMap;
    SeekBar seekWidth, seekBlue, seekGreen, seekRed;
    Button btClear, btDraw;

    List<LatLng> latLngList = new ArrayList<>();
    List<Marker> markerList = new ArrayList<>();
    int red = 0, green= 0, blue=0;

    Polyline polyline = null;
    PolylineOptions polylineOptions = null;

    private static int PERMISSION_LOCATION_STATE = 1001; //hopefully no other permission code conflict with this in the future, so watch out.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        seekWidth = findViewById(R.id.seek_width);
        seekRed = findViewById(R.id.seek_red);
        seekGreen = findViewById(R.id.seek_green);
        seekBlue = findViewById(R.id.seek_blue);
        btDraw=findViewById(R.id.bt_draw);
        btClear=findViewById(R.id.bt_clear);

        /* We decide to put our function inside a runner that runs on UI thread to at least try to
         * load the page before prompting users to allow location access, this will delay the prompt by 2 seconds.
         * Note: it's actually not compulsory, so you can remove it either way, it will work.
         * */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mapPermissionCheck();
            }
        }, 2000);

        btDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Draw Polyline on Map
                if (polyline!=null) polyline.remove();
                if(polylineOptions!=null){
                    //Create PolylineOptions
                    polyline = gMap.addPolyline(polylineOptions);
                    setWidth();
                }
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clear All
                if (polyline!=null) polyline.remove();
                for(Marker marker: markerList) marker.remove();
                latLngList.clear();
                markerList.clear();
                seekWidth.setProgress(3);
                seekBlue.setProgress(0);
                seekGreen.setProgress(0);
                seekRed.setProgress(0);
            }
        });

        seekRed.setOnSeekBarChangeListener(this);
        seekGreen.setOnSeekBarChangeListener(this);
        seekBlue.setOnSeekBarChangeListener(this);
    }

    private void initSupportFragment() {
        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.google_map);
        if(supportMapFragment!=null){
            supportMapFragment.getMapAsync(this);
        }
    }

    private void mapPermissionCheck() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            //Initialise SupportMapFragment when we're sure permission is granted to access location, else Map will not be ready and mapReady() will never be called.
            initSupportFragment();
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_LOCATION_STATE);
        }
    }

    private void setWidth() {
        seekWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Get Seekbar Progress
                int width = seekWidth.getProgress();
                if (polyline != null) {
                    //Set Polyline Width
                    polyline.setWidth(width);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
            gMap= googleMap;
            gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    //Create MarkerOptions
                    MarkerOptions markerOptions = new MarkerOptions().position(latLng);
                    //Create Marker
                    Marker marker = gMap.addMarker(markerOptions);
                    //Add Latlng and Marker
                    latLngList.add(latLng);
                    markerList.add(marker);

                    polylineOptions = new PolylineOptions().addAll(latLngList).clickable(true);
                }
            });
        }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.seek_red:
                red = i;
                break;
            case R.id.seek_green:
                green = i;
                break;
            case R.id.seek_blue:
                blue= i;
                break;
        }

        if(polyline !=null){
        //Set Polyline Color
            polyline.setColor(Color.rgb(red,green,blue));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /*
    * Right below here is a permission callback method that get called when ever an action is taken on a permission prompt request
    * So, if a user declined or accept, we can check and decide what to do next, in this case, we will try enforce the user to
    * give us location access in case they declined at first since we can't do much without the permission.
    * */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_LOCATION_STATE) { // remember PERMISSION_LOCATION_STATE? check above on how we parse it.
                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    new AlertDialog.Builder(this)
                        .setTitle("Location Permission Needed")
                        .setMessage("Daniel Poly App Need Your Location Permission To Proceed.")
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                mapPermissionCheck();
                            }
                        })
                        .show();
                }else{ //Meaning permission finally granted....hurray!!!
                    initSupportFragment();
                }
        }
    }

}