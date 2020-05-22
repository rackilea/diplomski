package com.muddco.fl99;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;;
import androidx.documentfile.provider.DocumentFile;


public class MainActivity extends AppCompatActivity {

    static String TAG = "TEST123";
    public static TextView fileView, uriView;
    public Context act = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileView = (TextView) findViewById(R.id.fileView);
        uriView = (TextView) findViewById(R.id.uriView);;

        showFileChooser();
    }

    private static final int FILE_SELECT_CODE = 0;

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a Directory"),
                    FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    Log.d(TAG, "File Uri: " + uri.toString());
                    uriView.setText("URI: "+ uri.toString());

                    DocumentFile dfile = DocumentFile.fromTreeUri(act, uri);
                    DocumentFile[] fileList = dfile.listFiles();
                    Log.d(TAG,fileList.toString() );
                    int jj=1;

                    for (DocumentFile docfile : fileList) {

                        Log.d(TAG, "File: " + docfile.getUri() + "\n");
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}