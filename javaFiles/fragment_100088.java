@Override
    public void onMapReady(GoogleMap googleMap) {
        File fileGet = new File("/storage/emulated/0/csvLogs/demo.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileGet));
            String line;
            while ((line = br.readLine()) !=null) {
                String[] token = line.split(",");
                double lat = Double.parseDouble(token[2]);
                double lon = Double.parseDouble(token[3]);
                LatLng Lat = new LatLng(lat, lon);
                googleMap.addMarker(new MarkerOptions().position(Lat).title(token[1]));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(Lat));
            }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

```