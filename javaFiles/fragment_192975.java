import android.location.Location;


 ArrayList<Marker> markers = new ArrayList<>();
markers = sortListbyDistance(markers, currentLocation.getLocation());


 public static ArrayList<Marker> sortListbyDistance(ArrayList<Marker> markers, final LatLng location){
        Collections.sort(markers, new Comparator<Marker>() {
            @Override
            public int compare(Marker marker2, Marker marker1) {
            //
                if(getDistanceBetweenPoints(marker1.getLocation(),location)>getDistanceBetweenPoints(marker2.getLocation(),location)){
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return markers;
    }


 public static float getDistanceBetweenPoints(double firstLatitude, double firstLongitude, double secondLatitude, double secondLongitude) {
        float[] results = new float[1];
        Location.distanceBetween(firstLatitude, firstLongitude, secondLatitude, secondLongitude, results);
        return results[0];
    }