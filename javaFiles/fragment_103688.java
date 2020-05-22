try {
        mSnapShot = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

        int PreviewSizeWidth = CameraApplication.Instance().getResources().getInteger(R.integer.FilterPreviewWidth);
        int PreviewSizeHeight = CameraApplication.Instance().getResources().getInteger(R.integer.FilterPreviewHeight);
        mPreviewBitmap = Bitmap.createScaledBitmap(mSnapShot, PreviewSizeWidth, PreviewSizeHeight, false);
        FiltersPreview();
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
        Log.e(TAG, "File not found");
        finish();
    }catch(IOException e){
          //do something
    }