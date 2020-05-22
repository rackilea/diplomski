ArrayList<LatLng> directionPoint = latLongList;
            PolylineOptions rectLine = new PolylineOptions().width(8).color(
                    Color.RED);

            for (int i = 0; i < directionPoint.size(); i++) {
                rectLine.add(directionPoint.get(i));
            }

            // Adding route on the map
            map.addPolyline(rectLine);