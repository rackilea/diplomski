Random random = new Random();
for (LatLng positionI : list) {
    for (LatLng positionJ : list) {
        int color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        if (positionI != positionJ) {
            Polyline line = CalRout.mMap.addPolyline(
                    new PolylineOptions().add(
                            positionI,
                            positionJ
                    ).width(3).color(color)
            );
        }
    }
}