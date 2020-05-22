//map is of type JMap
map.addMapEventListener(new MapEventListenerAdapter() {
    @Override
    public void mapReady(MapEvent event) {
        String layerDef = "{   \"geometryType\": \"esriGeometryPoint\",   \"type\": \"Feature Layer\",   \"typeIdField\": \"\",   \"drawingInfo\": {     \"renderer\": {       \"type\": \"simple\",       \"symbol\": {         \"type\": \"esriSMS\",         \"style\": \"esriSMSCircle\",         \"color\": [200, 40, 0, 255],         \"size\": 15,         \"angle\": 0,         \"xoffset\": 0,         \"yoffset\": 0       }     },     \"fixedSymbols\": true   },   \"fields\": [     {       \"name\": \"X\",       \"alias\": \"X\",       \"type\": \"esriFieldTypeDouble\",       \"editable\": true,       \"nullable\": true,       \"domain\": null     },     {       \"name\": \"Y\",       \"alias\": \"Y\",       \"type\": \"esriFieldTypeDouble\",       \"editable\": true,       \"nullable\": true,       \"domain\": null     }   ],   \"name\": \"My CSV Layer\" }";
        CSVLayer.CSVConfig csvConfig = new CSVLayer.CSVConfig();
        csvConfig.url = new File("/path/to/csv-file.csv").toURI().toString();
        csvConfig.columnDelimiter = ",";
        csvConfig.longitudeField = "X";
        csvConfig.latitudeField = "Y";
        try {
            final CSVLayer csvLayer = new CSVLayer(layerDef, csvConfig);
            map.getLayers().add(csvLayer);
        } catch (Exception ex) {
            //Handle the exception
        }
    }
});