MediaScannerConnection.scanFile(this, new String[]{file.getPath()},
            null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String path, Uri uri) {
                    // now visible in gallery
                }
            });