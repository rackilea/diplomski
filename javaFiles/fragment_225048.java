// return the new heading based on the required heading and turn rate
private float turnToRequestedHeading(float initialHeading, float requiredHeading, float turnRate) {
    //DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Started");
    float resultantHeading;
    int   direction = 1;            // clockwise, set anti-clockwise (-1) later if required
    if ((Math.signum(initialHeading) == Math.signum(requiredHeading)) || (Math.signum(initialHeading) == 0) || (Math.signum(requiredHeading) == 0)) {
        // both headings are on the same side of 0 so turn will not pass through the  +/- Pi discontinuity
        if (Math.max(Math.abs(requiredHeading) - Math.abs(initialHeading), Math.abs(initialHeading) - Math.abs(requiredHeading)) < turnRate) {
            // angle to be updated is less than turn rate
            resultantHeading= requiredHeading;
            /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path1");
        } else {
            // angle to be updated is greater than turn rate
            if (initialHeading < requiredHeading) {
                // turn clockwise
                resultantHeading = initialHeading + turnRate;
                /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path2");
            } else {
                // turn anti-clockwise
                resultantHeading = initialHeading - turnRate;
                /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path3");
            }
        }
    } else {
        // headings are on different sides of 0 so turn may pass through the +/- Pi discontinuity
        if (Math.abs(initialHeading) + Math.abs(requiredHeading) < turnRate) {
            // angle to be updated is less than turn rate (around 0)
            resultantHeading= requiredHeading;
            /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path4");
        } else if ((180 - Math.abs(initialHeading)) + (180 - Math.abs(requiredHeading)) < turnRate) {
            // angle to be updated is less than turn rate (around +/- Pi)
            resultantHeading= requiredHeading;
            /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path5");
        } else {
            // angle to be updated is greater than turn rate so calculate direction (previously assumed to be 1)
            if (initialHeading < 0) {
                if (requiredHeading > PIf + initialHeading) direction = -1;
            } else {
                if (requiredHeading > -PIf + initialHeading) direction = -1;
            }
            if ((direction == 1) && (initialHeading > PIf - turnRate)) {
                // angle includes the +/- Pi discontinuity, clockwise
                resultantHeading = -TWO_PIf + turnRate + initialHeading;
                /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path6 snap="+(resultantHeading > requiredHeading));
                if (resultantHeading > requiredHeading) resultantHeading = requiredHeading;
            } else if ((direction == -1) && (initialHeading < -PIf + turnRate)) {
                // angle includes the +/- Pi discontinuity, anti-clockwise
                resultantHeading = TWO_PIf - turnRate + initialHeading;
                /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path7 snap="+(resultantHeading < requiredHeading));
                if (resultantHeading < requiredHeading) resultantHeading = requiredHeading;
            } else {
                // angle does not includes the +/- Pi discontinuity
                resultantHeading = initialHeading + direction * turnRate;
                /*DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading(initialHeading="+initialHeading+", requiredHeading="+requiredHeading+", turnRate="+turnRate+"): Path8 direction="+direction);
            }
        }
    }
    // ensure -PI <= result <= PI
    if (resultantHeading < -PIf) resultantHeading = resultantHeading + TWO_PIf; 
    if (resultantHeading >= PIf)  resultantHeading = resultantHeading - TWO_PIf; 
    //DEBUG*/Log.d(this.getClass().getName(), "turnToRequestedHeading: Returning "+resultantHeading);
    return resultantHeading;
}