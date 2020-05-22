if(first)
            {
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(BusLocation, 15), 1000, null);
                first = false;
            }
            else{
                map.animateCamera(CameraUpdateFactory.newLatLng(BusLocation), 1000, null);
            }