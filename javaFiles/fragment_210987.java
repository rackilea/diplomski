Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    ShowNearbyPlaces(nearbyPlacesList);
                }
            });