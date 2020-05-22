public void saveBitmap(Bitmap bitmap) {

    if (createDirIfNotExists("TestApp")) {
        String filePath = Environment.getExternalStorageDirectory()
                + File.separator + "TestApp/TestSC" + date_value + "_" + time_value + ".png";
        File imagePath = new File(filePath);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            hideLoadingDialog();
            showAlert(getString(R.string.successfullySavedPic));
        } catch (FileNotFoundException e) {
            hideLoadingDialog();
            showAlert(getString(R.string.problemOccured));
            Log.e("error", e.getMessage(), e);
        } catch (IOException e) {
            hideLoadingDialog();
            showAlert(getString(R.string.problemOccured));
            Log.e("error", e.getMessage(), e);
        }
    } else {
        String filePath = Environment.getExternalStorageDirectory()
                + File.separator + "Pictures/TestSC" + date_value + "_" + time_value + ".png";
        File imagePath = new File(filePath);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            hideLoadingDialog();
            showAlert(getString(R.string.successfullySavedPic));
        } catch (FileNotFoundException e) {
            hideLoadingDialog();
            showAlert(getString(R.string.successfullySavedPic));
            Log.e("error", e.getMessage(), e);
        } catch (IOException e) {
            hideLoadingDialog();
            showAlert(getString(R.string.successfullySavedPic));
            Log.e("error", e.getMessage(), e);
        }
    }


}