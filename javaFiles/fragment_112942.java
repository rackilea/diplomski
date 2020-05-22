public class PdfDownload extends Activity {
    TextView tv_loading;
    Context context;

    int downloadedSize = 0, totalsize;
    float per = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isStoragePermissionGranted();
        super.onCreate(savedInstanceState);

        tv_loading = new TextView(this);
        tv_loading.setGravity(Gravity.CENTER);
        tv_loading.setTypeface(null, Typeface.BOLD);
        setContentView(tv_loading);
        downloadAndOpenPDF();
    }


    public static String getLastBitFromUrl(final String url) {
        return url.replaceFirst(".*/([^/?]+).*", "$1");
    }

    void downloadAndOpenPDF() {
        final String download_file_url = getIntent().getStringExtra("url");
        new Thread(new Runnable() {
            public void run() {
                Uri path = Uri.fromFile(downloadFile(download_file_url));
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Uri uri = FileProvider.getUriForFile(PdfDownload.this, BuildConfig.APPLICATION_ID, downloadFile(download_file_url));
                    intent.setDataAndType(uri, "application/pdf");
                    startActivity(intent);
                    finish();


                } catch (ActivityNotFoundException e) {
                    tv_loading
                            .setError("PDF Reader application is not installed in your device");
                }
            }
        }).start();

    }

    File downloadFile(String dwnload_file_path) {
        File file = null;
        try {
            URL url = new URL(dwnload_file_path);
            HttpURLConnection urlConnection = (HttpURLConnection) url
                    .openConnection();

            urlConnection.connect();

            String test = getLastBitFromUrl(dwnload_file_path);
            String dest_file_path = test.replace("%20", "_");
            // set the path where we want to save the file
            File SDCardRoot = Environment.getExternalStorageDirectory();
            // // create a new file, to save the downloaded file
            file = new File(SDCardRoot, dest_file_path);
            if (file.exists()) {
                return file;
            }
            FileOutputStream fileOutput = new FileOutputStream(file);

            // Stream used for reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            // this is the total size of the file which we are
            // downloading
            totalsize = urlConnection.getContentLength();
            setText("Starting PDF download...");

            // create a buffer...
            byte[] buffer = new byte[1024 * 1024];
            int bufferLength = 0;

            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                per = ((float) downloadedSize / totalsize) * 100;
                if ((totalsize / 1024) <= 1024) {
                    setText("Total PDF File size  : " + (totalsize / 1024)
                            + " KB\n\nDownloading PDF " + (int) per + "% complete");
                } else {
                    setText("Total PDF File size  : " + (totalsize / 1024) / 1024
                            + " MB\n\nDownloading PDF " + (int) per + "% complete");
                }
                // setText("configuring your book pleease wait a moment");
            }
            // close the output stream when complete //
            fileOutput.close();
            // setText("Download Complete. Open PDF Application installed in the device.");
            setText("configuaration is completed now your book is ready to read");
        } catch (final MalformedURLException e) {
            setTextError("Some error occured. Press back and try again.",
                    Color.RED);
        } catch (final IOException e) {
            setTextError("Some error occured. Press back and try again.",
                    Color.RED);
        } catch (final Exception e) {
            setTextError(
                    "Failed to download image. Please check your internet connection.",
                    Color.RED);
        }
        return file;
    }

    void setTextError(final String message, final int color) {
        runOnUiThread(new Runnable() {
            public void run() {
                tv_loading.setTextColor(color);
                tv_loading.setText(message);
            }
        });
    }

    void setText(final String txt) {
        runOnUiThread(new Runnable() {
            public void run() {
                tv_loading.setText(txt);
            }
        });

    }

    private static final String TAG = "MyActivity";

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);

        }
    }

}