package com.test.client;

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.ajaxloader.client.AjaxLoader.AjaxLoaderOptions;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MapOptions;
import com.google.maps.gwt.client.MapTypeId;

public class GwtTest implements EntryPoint {

    @Override
    public void onModuleLoad() {
        AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
        options.setOtherParms("sensor=false");
        Runnable callback = new Runnable() {
            public void run() {
                createMap();
            }
        };
        AjaxLoader.loadApi("maps", "3", callback, options);
    }

    public void createMap() {

        MapOptions mapOpts = MapOptions.create();
        mapOpts.setZoom(4);
        mapOpts.setCenter(LatLng.create(37.09024, -95.712891));
        mapOpts.setMapTypeId(MapTypeId.TERRAIN);
        mapOpts.setStreetViewControl(false);

        GoogleMap map = GoogleMap.create(Document.get().getElementById("map_canvas"), mapOpts);

        styleMap(map);
    }


    public native void styleMap(GoogleMap map) /*-{
        map.set('styles', [
          {
            "featureType": "road",
            "stylers": [
              { "visibility": "off" }
            ]
          },{
            "featureType": "poi",
            "stylers": [
              { "visibility": "off" }
            ]
          },{
            "stylers": [
              { "invert_lightness": true }
            ]
          }
        ]);
    }-*/;
}