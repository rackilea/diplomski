// Check permission for INTERNET
if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET) != 
        PackageManager.PERMISSION_GRANTED) {
    // Request Permissions Now
    ActivityCompat.requestPermissions(getActivity(),
            new String[]{Manifest.permission.INTERNET},
            MainActivity.REQUEST_INTERNET);
}