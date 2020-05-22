try {
            DB snappydb = DBFactory.open(getActivity()); //create or open an existing databse using the default name

//Saving List of LatLng
            ArrayList<LatLng> listOfLatLng = new ArrayList<LatLng>();
            snappydb.put("LATLNG", listOfLatLng);


//Retrieving List of LatLngs
            ArrayList<LatLng> listOfLatLngNew = snappydb.get("LATLNG",ArrayList.class);


            snappydb.close();

        } catch (SnappydbException e) {
            e.printStackTrace();
        }