new Handler(Looper.getMainLooper()).post(new Runnable() {
        @Override
        public void run() {
            Iterator<HashMap.Entry<Integer, Marker>> it = Map.markerMap
                    .entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry<Integer, Marker> entery = it
                        .next();
                int key = entery.getKey();
                Map.marker = Map.markerMap.get(key);
                System.out.println("test marker " + Map.marker );
                //Line 120.
                Map.marker.remove();
                // Remove from map using iterator
                it.remove();

                // Marker value = entery.getValue();
            }
        }
    });