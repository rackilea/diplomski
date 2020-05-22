package com.epichorns.compass3D;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Compass3DActivity extends Activity {
    //Textviews for showing angle data
    TextView mTextView_azimuth;
    TextView mTextView_pitch;
    TextView mTextView_roll;

    TextView mTextView_filtered_azimuth;
    TextView mTextView_filtered_pitch;
    TextView mTextView_filtered_roll;


    float mAngle0_azimuth=0;
    float mAngle1_pitch=0;
    float mAngle2_roll=0;

    float mAngle0_filtered_azimuth=0;
    float mAngle1_filtered_pitch=0;
    float mAngle2_filtered_roll=0;

    private Compass3DView mCompassView;

    private SensorManager sensorManager;
    //sensor calculation values
    float[] mGravity = null;
    float[] mGeomagnetic = null;
    float Rmat[] = new float[9];
    float Imat[] = new float[9];
    float orientation[] = new float[3];
    SensorEventListener mAccelerometerListener = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}

        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                mGravity = event.values.clone();
                processSensorData();
            }
        }   
    };
    SensorEventListener mMagnetometerListener = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}

        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
                mGeomagnetic = event.values.clone();
                processSensorData();                
                update();
            }
        }   
    };

    private float restrictAngle(float tmpAngle){
        while(tmpAngle>=180) tmpAngle-=360;
        while(tmpAngle<-180) tmpAngle+=360;
        return tmpAngle;
    }

    //x is a raw angle value from getOrientation(...)
    //y is the current filtered angle value
    private float calculateFilteredAngle(float x, float y){ 
        final float alpha = 0.3f;
        float diff = x-y;

        //here, we ensure that abs(diff)<=180
        diff = restrictAngle(diff);

        y += alpha*diff;
        //ensure that y stays within [-180, 180[ bounds
        y = restrictAngle(y);

        return y;
    }



    public void processSensorData(){
        if (mGravity != null && mGeomagnetic != null) { 
            boolean success = SensorManager.getRotationMatrix(Rmat, Imat, mGravity, mGeomagnetic);
            if (success) {              
                SensorManager.getOrientation(Rmat, orientation);
                mAngle0_azimuth = (float)Math.toDegrees((double)orientation[0]); // orientation contains: azimut, pitch and roll
                mAngle1_pitch = (float)Math.toDegrees((double)orientation[1]); //pitch
                mAngle2_roll = -(float)Math.toDegrees((double)orientation[2]); //roll               
                mAngle0_filtered_azimuth = calculateFilteredAngle(mAngle0_azimuth, mAngle0_filtered_azimuth);
                mAngle1_filtered_pitch = calculateFilteredAngle(mAngle1_pitch, mAngle1_filtered_pitch);
                mAngle2_filtered_roll = calculateFilteredAngle(mAngle2_roll, mAngle2_filtered_roll);    
            }           
            mGravity=null; //oblige full new refresh
            mGeomagnetic=null; //oblige full new refresh
        }
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        LinearLayout ll = new LinearLayout(this);       
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);      
        ll.setLayoutParams(llParams);      
        ll.setOrientation(LinearLayout.VERTICAL);      
        ViewGroup.LayoutParams txtParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);        
        mTextView_azimuth = new TextView(this);
        mTextView_azimuth.setLayoutParams(txtParams);
        mTextView_pitch = new TextView(this);
        mTextView_pitch.setLayoutParams(txtParams);
        mTextView_roll = new TextView(this);
        mTextView_roll.setLayoutParams(txtParams);      
        mTextView_filtered_azimuth = new TextView(this);
        mTextView_filtered_azimuth.setLayoutParams(txtParams);
        mTextView_filtered_pitch = new TextView(this);
        mTextView_filtered_pitch.setLayoutParams(txtParams);
        mTextView_filtered_roll = new TextView(this);
        mTextView_filtered_roll.setLayoutParams(txtParams);

        mCompassView = new Compass3DView(this);        
        ViewGroup.LayoutParams compassParams = new ViewGroup.LayoutParams(200,200);
        mCompassView.setLayoutParams(compassParams);

        ll.addView(mCompassView);
        ll.addView(mTextView_azimuth);
        ll.addView(mTextView_pitch);
        ll.addView(mTextView_roll);
        ll.addView(mTextView_filtered_azimuth);
        ll.addView(mTextView_filtered_pitch);
        ll.addView(mTextView_filtered_roll);

        setContentView(ll);

        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(mAccelerometerListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI); 
        sensorManager.registerListener(mMagnetometerListener, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_UI);
        update();       
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        sensorManager.unregisterListener(mAccelerometerListener);
        sensorManager.unregisterListener(mMagnetometerListener);
    }


    private void update(){
        mCompassView.changeAngles(mAngle1_filtered_pitch,  mAngle2_filtered_roll, mAngle0_filtered_azimuth);

        mTextView_azimuth.setText("Azimuth: "+String.valueOf(mAngle0_azimuth));
        mTextView_pitch.setText("Pitch: "+String.valueOf(mAngle1_pitch));
        mTextView_roll.setText("Roll: "+String.valueOf(mAngle2_roll));

        mTextView_filtered_azimuth.setText("Azimuth: "+String.valueOf(mAngle0_filtered_azimuth));
        mTextView_filtered_pitch.setText("Pitch: "+String.valueOf(mAngle1_filtered_pitch));
        mTextView_filtered_roll.setText("Roll: "+String.valueOf(mAngle2_filtered_roll));

    }
}