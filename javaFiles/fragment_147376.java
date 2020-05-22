myMap.setOnCameraChangeListener(new OnCameraChangeListener()
        {
            @SuppressLint("DefaultLocale") @Override
            public void onCameraChange(CameraPosition position)
            {
                // Get the latlng of the map center
                LatLng mapCenter = myMap.getCameraPosition().target;

                // Create a centerlocation based on the map's latlng
                Location centerLocation = new Location("CenterLocation");
                centerLocation.setLatitude(mapCenter.latitude);
                centerLocation.setLongitude(mapCenter.longitude);

                // Location for storage of the city closest to the map
                Location closestCity = new Location("ClosestCity");
                float distance = 0;

                for (City city : cities)
                {
                    Location cityLocation = new Location(city.getCityName());
                    cityLocation.setLatitude(city.getLatitude());
                    cityLocation.setLongitude(city.getLongitude());

                    float currentCityDistance = cityLocation.distanceTo(centerLocation);

                    if(distance == 0)
                    {
                        distance = currentCityDistance;
                        closestCity = cityLocation;
                    }

                    if(currentCityDistance < distance)
                    {
                        distance = currentCityDistance;
                        closestCity = cityLocation;
                    }
                }

                // Convert from meters to kilometers
                float distanceKm = distance / 1000;
                String kilometersString = String.format("%.2f", distanceKm);

                // Present a toast with information
                Toast.makeText(getBaseContext(), "Distance to " + closestCity.getProvider() + ": " + kilometersString + " km", Toast.LENGTH_SHORT).show();
            }
        });