/*
 * Copyright (c) 2011-2019 HERE Europe B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.heremapapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.here.android.mpa.common.ApplicationContext;
import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.MapEngine;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.PositioningManager;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.mapping.MapView;
import java.io.File;


/**
 * This class encapsulates the properties and functionality of the Map view.It also implements 4
 * types of discovery requests that HERE Android SDK provides as example.
 */
public class MapFragmentView extends Fragment {

    private Activity m_activity;
    private PositioningManager positioningManager;
    private MapEngine mapEngine = MapEngine.getInstance();
    private MapView mapView;
    private static View v;
    private MapFragment mapFragmentView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("onCreateView Çağrıldı");

        v = inflater.inflate(R.layout.map_frame, container, false);

        mapFragmentView = new MapFragment();

        FragmentManager fm = m_activity.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.simpleFrameLayout,mapFragmentView).commit();

        //Here cinsinden ApplicationContext yarattık aşağıda:
        com.here.android.mpa.common.ApplicationContext newContext =new ApplicationContext(m_activity);

        //O yarttığımız contexti MapFragmentView.init methodu için kullandık (Mine de vardı ;) ):
        mapFragmentView.init(newContext, new OnEngineInitListener() {
            @Override
            public void onEngineInitializationCompleted(Error error) {
                if (error == Error.NONE) {
                    map = mapFragmentView.getMap();
                } else {
                    Toast.makeText(m_activity,
                            "ERROR: Cannot initialize Map with error " + error,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(m_activity);
        System.out.println("ONETEŞ");
        try {
            m_activity = (AppCompatActivity) activity;
            //mCallbacks = (MyNavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            System.out.println("ONETEŞ SIKINTI");
        }
    }


    public MapFragmentView() {
    }



    private Map map;

    public void initMapFragment() {
        Context context =getContext();
        ApplicationContext appContext = new ApplicationContext(context);
        /* Locate the mapFragment UI element */
        mapView = new MapView(context);
        System.out.println("Application context bu: "+appContext.getClass().toString());


        // Set path of isolated disk cache
        String diskCacheRoot = Environment.getExternalStorageDirectory().getPath()
                + File.separator + ".isolated-here-maps";
        // Retrieve intent name from manifest
        String intentName = "";
        try {
            ApplicationInfo ai = m_activity.getPackageManager().getApplicationInfo(m_activity.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            intentName = bundle.getString("INTENT_NAME");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(this.getClass().toString(), "Failed to find intent name, NameNotFound: " + e.getMessage());
        }
        boolean success = com.here.android.mpa.common.MapSettings.setIsolatedDiskCacheRootPath(diskCacheRoot, intentName);
        if (!success) {
            // Setting the isolated disk cache was not successful, please check if the path is valid and
            // ensure that it does not match the default location
            // (getExternalStorageDirectory()/.here-maps).
            // Also, ensure the provided intent name does not match the default intent name.
        } else {

            if (mapView != null) {



                /* Initialize the SupportMapFragment, results will be given via the called back. m_mapFragment.init(context,new OnEngineInitListener() */
                mapEngine.init(appContext, new OnEngineInitListener() {
                    @Override
                    public void onEngineInitializationCompleted(OnEngineInitListener.Error error) {
                        if (error == Error.NONE) {
                            positioningManager = PositioningManager.getInstance();
                            positioningManager.start(PositioningManager.LocationMethod.GPS_NETWORK_INDOOR);
                            map = mapView.getMap();
                            GeoCoordinate myCurrentPosition = positioningManager.getPosition().getCoordinate();
                        } else {
                            Toast.makeText(m_activity,
                                    "ERROR: Cannot initialize Map with error " + error,
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }
    }

    public void setM_activity(AppCompatActivity m_activity) {
        this.m_activity = m_activity;
    }


}