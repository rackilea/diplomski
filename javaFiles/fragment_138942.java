float scale = 1.0; //factor used in glScalef
float previousPinchScale; //needed to remember from previous methode call
private float midPoint(float x, float y, float xtwo, float ytwo) {
    float currentPinchScale = FloatMath.sqrt((x-xTwo)*(x-xTwo) + (y-yTwo)*(y-yTwo)); //current distance between both "touches"
    if (touched) { //gesture just began:
        previousPinchScale = currentPinchScale; //Save relative information about touch positions
        touched = false;
    }
    else { //gesture in progress:
        /*
         At this point we have 2 values of "PinchScale" for this and previous "midPoint" method call.
         The factor of relative change in this distance should be applied to current scene scale:
         currentPinchScale/previousPinchScale is the "relative change", for instance if the distance between the 2 touches would be 10% this factor would return 1.1
         Since we have to consider that scene might already be zoomed you need to take previous scale and multiply it with this change..
         */
        scale *= currentPinchScale/previousPinchScale; //scale used in glScalef
        previousPinchScale = currentPinchScale; //remember the new position of "midPoint" call
    }
    return scale;
}