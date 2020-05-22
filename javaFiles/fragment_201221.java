if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

    if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
     != PackageManager.PERMISSION_GRANTED) {

        ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 123);
    } else {

        //GPS method
    }
} else {

    //GPS method
}