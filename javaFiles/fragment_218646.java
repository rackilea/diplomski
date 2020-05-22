import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import gmbh.webagenten.recycling.PostsDatabaseHelper;
import gmbh.webagenten.recycling.SQLiteSampleActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.ContentValues.TAG;
import static gmbh.webagenten.recycling.R.attr.title;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private static final int EDIT_REQUEST = 1;
    Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        // Get singleton instance of database

        Intent intent = getIntent(); 
        bmp = (Bitmap) intent.getParcelableExtra("BitmapImage");      // getting the bitmap data from the edit activity.

        //PostsDatabaseHelper databaseHelper = PostsDatabaseHelper.getInstance((Context) this);

        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap map) {

        //Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.id.imageView1);
        this.mMap = map;
        try {
            mMap.setMyLocationEnabled(true);
        } catch (SecurityException e) {
            LatLng hamburg = new LatLng(53.551085, 9.993682);
            mMap.addMarker(new MarkerOptions().position(hamburg).title("Marker in Hamburg")
                .icon(BitmapDescriptorFactory.fromBitmap(bmp)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(hamburg));
            //PostsDatabaseHelper helper = PostsDatabaseHelper.getInstance(this);
            //helper.getReadableDatabase();
            //Log.d(TAG, "Database in use");
         }

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(final LatLng latLng) {

                Intent edit = new Intent(MapsActivity.this, EditActivity.class);
                edit.putExtra("location", latLng);
                Log.d("Längen-und Breitengrad:", String.valueOf(latLng));

                MapsActivity.this.startActivityForResult(edit, EDIT_REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case (EDIT_REQUEST) : {
                if (resultCode == Activity.RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    MarkerOptions markerOptions = data.getParcelableExtra("marker");
                    MarkerOptions markerImage = data.getParcelableExtra("data");
                    mMap.addMarker(markerOptions);
                    //mMap.addMarker(markerImage);
                }
                break;
            }
        }
    }
}