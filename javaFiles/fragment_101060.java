takePhoto(){
 if (Build.VERSION.SDK_INT >= 24) {
                taken_photo_uri = FileProvider.getUriForFile(MyApplicaiton.getContext(),
                        activity.getResources().getString(R.string.main_package),
                        output_image);
            } else {
                taken_photo_uri = Uri.fromFile(output_image);
            }
}