@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case CAMERA_REQUEST:
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(photo);
                    //Hide video view
                    videoview.setVisibility(View.GONE);

                }
                break;
            case REQUEST_VIDEO_CAPTURE:
                //bring your video stuff here
                videoview.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                break;
        }
    }