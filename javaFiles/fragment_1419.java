ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

   for(int i = 0;i<jsonArryDetails.length();i++){
            HashMap<String, String> map = new HashMap<String, String>();
            JSONObject mapDetails =        
                      jsonArryDetails.getJSONObject(i);

            lat1 = mapDetails.getString(LAT);
            lng1 = mapDetails.getString(LNG);
            address1 = mapDetails.getString(ADDRESS);
            time1 = mapDetails.getString(CTIME);
            map.put(LAT, lat1);
            map.put(LNG, lg1);
            map.put(ADDRESS, address1 );
            map.put(CTIME, time1 );

            mylist.add(map);

        }