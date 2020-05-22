//min scan
    double minTimeArray = timeArray[0];
    for (cnt = 0; cnt < timeArray.length; cnt++) {
        if (timeArray[cnt] < minTimeArray) {
            minTimeArray = timeArray[cnt];
        }
    Log.i("Array", "value: " + String.valueOf(minTimeArray) + "  at: " + cnt);
    }