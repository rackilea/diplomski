import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.data;
import static android.R.attr.id;
import static android.content.ContentValues.TAG;
import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;



public class EditActivity extends Activity {


    public static int count = 0;
    static final int REQUEST_TAKE_PHOTO = 1;
    private static final String KEY_MARKER_ID = "id";
    private static final String KEY_MARKER_TITLE = "title";
    private static final String KEY_MARKER_DATE = "date";
    private static final String KEY_MARKER_LOC = "location";
    private static final String KEY_MARKER_LAT = "latlng";
    private static final String KEY_MARKER_NAME = "name";
    private static final String KEY_MARKER_PIC = "picture";
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editactivity);
        PostsDatabaseHelper helper = PostsDatabaseHelper.getInstance(this);
        helper.getReadableDatabase();
        this.imageView = (ImageView)this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.btnCapture);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        final LatLng latlng = getIntent().getParcelableExtra("location");
        //final MarkerImage markerImage = getIntent().getParcelableExtra("data");
        final EditText title = (EditText) findViewById(R.id.title);
        final EditText date = (EditText) findViewById(R.id.date);
        final EditText location = (EditText) findViewById(R.id.location);
        final ImageView image = (ImageView) findViewById(R.id.imageView1);
        final EditText name = (EditText) findViewById(R.id.name);
        Button button = (Button) findViewById(R.id.save);
        final Button camerabutton = (Button) findViewById(R.id.btnCapture);
        final Intent getCameraImage = new Intent(ACTION_IMAGE_CAPTURE);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
                MarkerOptions marker = new MarkerOptions().position(latlng)
                        .icon(BitmapDescriptorFactory.fromBitmap(bmp)
                        );
                if (title.getText() != null) {
                    marker.title(title.getText().toString());
                }
                if (date.getText() != null) {
                    marker.getPosition();
                    Log.d("String Value of Marker:", String.valueOf(marker));
                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra("marker", marker);
                resultIntent.putExtra("picture", getCameraImage);
                intent.putExtra("BitmapImage", photo);          // passing the bitmap to the next activity . and retrieve it to the next activity
                Log.d("Längen-und Breitengrad:", String.valueOf(marker));
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }

        });



  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
           `photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }


}