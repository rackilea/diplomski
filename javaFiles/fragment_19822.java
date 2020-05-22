public static void getAddressFromLocation(
        final Location location, final Context context, final Handler handler) {
    Thread thread = new Thread() {
        @Override public void run() {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());   
            String result = null;
            try {
                List<Address> list = geocoder.getFromLocation(
                        location.getLatitude(), location.getLongitude(), 1);
                if (list != null && list.size() > 0) {
                    Address address = list.get(0);
                    // sending back first address line and locality
                    result = address.getAddressLine(0) + ", " + address.getLocality();
                }
            } catch (IOException e) {
                Log.e(TAG, "Impossible to connect to Geocoder", e);
            } finally {
                Message msg = Message.obtain();
                msg.setTarget(handler);
                if (result != null) {
                    msg.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("address", result);
                    msg.setData(bundle);
                } else 
                    msg.what = 0;
                msg.sendToTarget();
            }
        }
    };
    thread.start();
}