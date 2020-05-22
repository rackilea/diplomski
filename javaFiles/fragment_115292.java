MediaScannerConnection.scanFile(getActivity(), toBeScannedStr, null, new OnScanCompletedListener() {

                @Override
                public void onScanCompleted(String path, Uri uri) {
                    System.out.println("SCAN COMPLETED: " + path);

                }
            });