package com.mapbox.mapboxandroiddemo.examples.basics;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.MapboxDirections;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxandroiddemo.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static com.mapbox.core.constants.Constants.PRECISION_6;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineCap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineJoin;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.lineWidth;


/**
 * The most basic example of adding a map to an activity.
 */
public class SimpleMapViewActivity extends AppCompatActivity implements
  OnMapReadyCallback, PermissionsListener, View.OnClickListener, MapboxMap.OnMapClickListener, MapboxMap.OnMarkerClickListener {

  private MapView mapView;

  private static final String TAG = "SimpleMapViewActivity";

  private MapboxDirections client;
  private DirectionsRoute currentRoute;
  private static final String ROUTE_LAYER_ID = "route-layer-id";
  private static final String ROUTE_SOURCE_ID = "route-source-id";
  private PermissionsManager permissionsManager;
  private MapboxMap mapboxMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Mapbox access token is configured here.

    Mapbox.getInstance(this, getString(R.string.access_token));

    setContentView(R.layout.activity_basic_simple_mapview);

    mapView = findViewById(R.id.mapView);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(this);
  }


  @Override
  public void onMapReady(@NonNull final MapboxMap mapboxMap) {
    mapboxMap.setStyle(Style.MAPBOX_STREETS,
      new Style.OnStyleLoaded() {
        @Override
        public void onStyleLoaded(@NonNull Style style) {
          SimpleMapViewActivity.this.mapboxMap = mapboxMap;

          enableLocationComponent(style);

          Point origin = Point.fromLngLat(-3.588098, 37.176164);

          Point destination = Point.fromLngLat(-3.601845, 37.184080);

          initSource(style);

          initLayers(style);

          getRoute(origin, destination);

          mapboxMap.addOnMapClickListener(SimpleMapViewActivity.this);

          mapboxMap.setOnMarkerClickListener(SimpleMapViewActivity.this);

        }
      });
  }


  private void initLayers(@NonNull Style loadedMapStyle) {
    LineLayer routeLayer = new LineLayer(ROUTE_LAYER_ID, ROUTE_SOURCE_ID);

    routeLayer.setProperties(
      lineCap(Property.LINE_CAP_ROUND),
      lineJoin(Property.LINE_JOIN_ROUND),
      lineWidth(5f),
      lineColor(Color.parseColor("#009688"))
    );
    loadedMapStyle.addLayer(routeLayer);

  }

  private void initSource(@NonNull Style loadedMapStyle) {
    loadedMapStyle.addSource(new GeoJsonSource(ROUTE_SOURCE_ID,
      FeatureCollection.fromFeatures(new Feature[] {})));

  }

  private void getRoute(Point origin, Point destination) {
    client = MapboxDirections.builder()
      .origin(origin)
      .destination(destination)
      .overview(DirectionsCriteria.OVERVIEW_FULL)
      .profile(DirectionsCriteria.PROFILE_DRIVING)
      .accessToken(Mapbox.getAccessToken())
      .build();

    client.enqueueCall(new Callback<DirectionsResponse>() {
      @Override
      public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
// You can get the generic HTTP info about the response
        Log.d(TAG, "Response code: " + response.code());
        if (response.body() == null) {
          Log.d(TAG, "No routes found, make sure you set the right user and access token.");
          return;
        } else if (response.body().routes().size() < 1) {
          Log.d(TAG, "No routes found");
          return;
        }

// Get the directions route
        currentRoute = response.body().routes().get(0);

// Make a toast which displays the route's distance
                /*Toast.makeText(SimpleMapViewActivity.this, String.format(
                        getString(R.string.directions_activity_toast_message),
                        currentRoute.distance()), Toast.LENGTH_SHORT).show();*/

        if (mapboxMap != null) {
          mapboxMap.getStyle(new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {

// Retrieve and update the source designated for showing the directions route
              GeoJsonSource source = style.getSourceAs(ROUTE_SOURCE_ID);

// Create a LineString with the directions route's geometry and
// reset the GeoJSON source for the route LineLayer source
              if (source != null) {
                Log.d(TAG, "onResponse: source != null");
                source.setGeoJson(FeatureCollection.fromFeature(
                  Feature.fromGeometry(LineString.fromPolyline(currentRoute.geometry(), PRECISION_6))));
              }
            }
          });
        }
      }

      @Override
      public void onFailure(Call<DirectionsResponse> call, Throwable throwable) {
        Log.d(TAG, "Error: " + throwable.getMessage());
        Toast.makeText(SimpleMapViewActivity.this, "Error: " + throwable.getMessage(),
          Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public void onClick(View view) {

  }

  @SuppressWarnings( {"MissingPermission"})
  private void enableLocationComponent(@NonNull Style loadedMapStyle) {
    // Check if permissions are enabled and if not request
    if (PermissionsManager.areLocationPermissionsGranted(this)) {

      // Get an instance of the component
      LocationComponent locationComponent = mapboxMap.getLocationComponent();

      // Activate with options
      locationComponent.activateLocationComponent(
        LocationComponentActivationOptions.builder(this, loadedMapStyle).build());

      // Enable to make component visible
      locationComponent.setLocationComponentEnabled(true);

      // Set the component's camera mode
      locationComponent.setCameraMode(CameraMode.TRACKING);

      // Set the component's render mode
      locationComponent.setRenderMode(RenderMode.COMPASS);
    } else {
      permissionsManager = new PermissionsManager(this);
      permissionsManager.requestLocationPermissions(this);
    }
  }


  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  @Override
  public void onExplanationNeeded(List<String> permissionsToExplain) {
    Toast.makeText(this, R.string.user_location_permission_explanation, Toast.LENGTH_LONG).show();
  }

  @Override
  public void onPermissionResult(boolean granted) {
    if (granted) {
      mapboxMap.getStyle(new Style.OnStyleLoaded() {
        @Override
        public void onStyleLoaded(@NonNull Style style) {
          enableLocationComponent(style);
        }
      });
    } else {
      Toast.makeText(this, R.string.user_location_permission_not_granted, Toast.LENGTH_LONG).show();
      finish();
    }
  }

  @Override
  public boolean onMapClick(@NonNull LatLng point) {


    return true;
  }

  @Override
  public boolean onMarkerClick(@NonNull Marker marker) {
    return false;
  }
}