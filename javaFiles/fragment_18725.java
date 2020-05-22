ArrayList<LatLng> polylist = new ArrayList<>();

        String[] parts = news.getArea().replace("POLYGON ((","").replace("))","").split("(?<!\\\\), ");

        for(String part : parts){
            String[] subpart = part.split(" ");
            polylist.add(new LatLng(Double.parseDouble(subpart[1]), Double.parseDouble(subpart[0])));
        }

        PolygonOptions polygonOptions = new PolygonOptions();

        for(LatLng latLng : polylist){
            polygonOptions.add(latLng);         
        }          

        map.addPolygon(polygonOptions);