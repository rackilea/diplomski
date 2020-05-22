JSONArray array = jObject.getJSONArray("routes");
            JSONObject routes = array.getJSONObject(0);
            JSONArray legs = routes.getJSONArray("legs");
            JSONObject steps = legs.getJSONObject(0);
            JSONObject distance = steps.getJSONObject("distance");

            Log.i("trJSON", "Distance String: " + distanceD.toString());
            Double dist = Double.parseDouble(distanceD.getString("text").replaceAll("[^\\.0123456789]","") );
            Log.i("trJSON", "Distance Double: " + dist);