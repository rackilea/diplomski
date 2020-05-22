private static String filepath = Environment.getExternalStorageDirectory().getPath()+"/myfile.pdf";   

    File file = new File(filepath);

    if (file.exists()) {
        Uri path = Uri.fromFile(file);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(path, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            startActivity(intent);
        } 
        catch (ActivityNotFoundException e) {
            Log.d(TAG,e.getMessage());
        }
    }