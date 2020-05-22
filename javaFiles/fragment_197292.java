package com.mapbox.mapboxandroiddemo.examples.basics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.mapbox.mapboxandroiddemo.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.net.URI;
import java.net.URISyntaxException;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.mapbox.mapboxsdk.style.layers.Property.ICON_ANCHOR_BOTTOM;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAnchor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;


/**
 * The most basic example of adding a map to an activity.
 */
public class SimpleMapViewActivity extends AppCompatActivity {

  private MapView mapView;
  private MapboxMap mapboxMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Mapbox access token is configured here. This needs to be called either in your application
    // object or in the same activity which contains the mapview.
    Mapbox.getInstance(this, getString(R.string.access_token));

    // This contains the MapView in XML and needs to be called after the access token is configured.
    setContentView(R.layout.activity_basic_simple_mapview);

    mapView = findViewById(R.id.mapView);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(@NonNull MapboxMap mapboxMap) {
        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
          @Override
          public void onStyleLoaded(@NonNull Style style) {
            SimpleMapViewActivity.this.mapboxMap = mapboxMap;

            // Map is set up and the style has loaded. Now you can add data or make other map adjustments.

            GeoJSONToMap("source-id1", "first-layer-id", "asset://spinning_icon.geojson");

            GeoJSONToMap("source-id2", "second-layer-id", "asset://la_heatmap_styling_points.geojson");

          }
        });
      }
    });
  }

  public void GeoJSONToMap(String sourceId, String layerId, String asset_id) {
    mapboxMap.getStyle(new Style.OnStyleLoaded() {
      @Override
      public void onStyleLoaded(@NonNull Style style) {

        try {
          GeoJsonSource source = new GeoJsonSource(sourceId, new URI(asset_id));

          style.addSource(source);

          Bitmap icon;

          if (layerId.equals("first-layer-id")) {
            icon = BitmapFactory.decodeResource(getResources(), R.drawable.red_marker);
          } else {
            icon = BitmapFactory.decodeResource(getResources(), R.drawable.yellow_marker);
          }

          style.addImage(layerId + " marker", icon);

          SymbolLayer symbolLayer = new SymbolLayer(layerId, sourceId);

          symbolLayer.setProperties(
              iconImage(layerId + " marker"),
              iconAllowOverlap(true),
              iconAnchor(ICON_ANCHOR_BOTTOM), // You should use this if you're using a pin-like icon image
              iconIgnorePlacement(true)
          );

          style.addLayer(symbolLayer);

        } catch (URISyntaxException e) {
          e.printStackTrace();
        }
      }
    });
  }

  // Add the mapView lifecycle to the activity's lifecycle methods
  @Override
  public void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  protected void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }
}