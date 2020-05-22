public class DistanceFixedImpl extends AbstractStrategyImpl {

private static String TAG = "DistanceFixed"; 
protected int distance;

protected Location lastLocation;


public DistanceFixedImpl(Context context) {
    super(context);
    distance = PreferencesData.getInt(context,
            DistanceBasedFixedDistance.STATE_DISTANCE, 30);
}

/**
 * This is just to enable DistanceAccelerometer, which extends this class, to change what is sent to server
 * 
 * @param TAG
 */
protected void setTAG(String TAG) {
    DistanceFixedImpl.TAG = TAG;
}

public void setLocationStrategyListener(
        LocationStrategyUpdateListener strategyUpdateListener) {
    this.strategyListener = strategyUpdateListener;
}

public void setDistance(int distance) {
    PreferencesData.saveInt(context,
            DistanceBasedFixedDistance.STATE_DISTANCE, distance);
    this.distance = distance;
}

@Override
public void startStrategy() {
    startUsingGPS();
    strategyListener.strategyMessageCallback("Awaiting GPS first-fix"); 
}

@Override
public void stopStrategy() {
    stopUsingGPS();
    super.stopStrategy();
}

@Override
public void onFirsFixChanged(boolean hasGPSfix) {
    strategyListener.strategyMessageCallback("Received a first-fix change to: " + hasGPSfix);
}

private Integer[] outputPercentages = new Integer[]{25,50,75,100};
private int outputPercentIndex;

@Override
public void onLocationChanged(Location location) {
    incrementLocationChangesOnDevice();
    // ignore any incomming locations as long as first fix is not set
    if (!hasFirstFix())
        return;

    if (lastLocation == null) {

        /**---------------------------------------------------------------------------------------------- *
         *  No location to compare against yet, so we just save it as two is needed to calculate distance * 
         * -----------------------------------------------------------------------------------------------*/

        lastLocation = location;
        sendLocationToServer(location, TAG);
    } else {
        float distanceMoved = lastLocation.distanceTo(location);

        int outputDistancePercent = outputPercentages[outputPercentIndex];
        if ((distanceMoved/distance)*100 >= outputDistancePercent) { 
            outputPercentIndex = (outputPercentIndex+1) % 4;
            strategyListener.strategyMessageCallback("Moved: " + outputDistancePercent + "% of " + distance + " meters");
        }

        if (distanceMoved > distance) {

            // threshold exceeded - send location to server

            strategyListener.strategyMessageCallback("SEND: " + distanceMoved
                    + " meters");

            sendLocationToServer(location, TAG);

            lastLocation = location;

        } 

    }
}

}