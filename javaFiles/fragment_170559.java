MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null,
        new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
                image_path = uri.toString();

               Intent intent = new Intent(context,Activity2.class);
               intent.putExtra("image_path", image_path);
               startActivity(intent);
            }
        });