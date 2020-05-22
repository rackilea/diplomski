package com.example.kiran.cr7;

    import android.app.DownloadManager;
    import android.content.Context;
    import android.net.ConnectivityManager;
    import android.net.NetworkInfo;
    import android.net.Uri;
    import android.os.Bundle;
    import android.app.Activity;
    import android.view.View;
    import android.view.animation.Animation;
    import android.view.animation.AnimationUtils;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.Toast;

    import com.squareup.picasso.Picasso;

    public class Test extends Activity {
        private ImageView detailimage;
        private Button download;
        DownloadManager downloadManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test);

            download = (Button) findViewById(R.id.Download);
            detailimage = (ImageView) findViewById(R.id.detailimage);
            final Animation animAlpha = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);

            if (getIntent().getSerializableExtra("item") != null) {
                 final Item i = (Item) getIntent().getSerializableExtra("item");
                Picasso.with(this)
                        .load(i.img)
                        .resize(500,600)
                        .placeholder(R.drawable.fern)
                        .error(android.R.drawable.stat_notify_error)
                        .into(detailimage);

                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    //Toast.makeText(Test.this, "Network Connection available", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Test.this, "No Network Connection", Toast.LENGTH_LONG).show();
                }

                download.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.startAnimation(animAlpha);
                        downloadManager =(DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        Uri uri = Uri.parse(i.img);
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        Long reference = downloadManager.enqueue(request);
                    }
                });

            }

        }
    }