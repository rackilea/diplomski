Returns Time Diffrence in Seconds :




long elapsed_time = 0L;
    java.util.Date startTime = null;
    java.util.Date endTime = null;
    double fsec = 0L;
    String rSec = "";   

        startTime = new java.util.Date();

        <--------Some Operation----->

        endTime = new java.util.Date();
        elapsed_time = endTime.getTime() - startTime.getTime();
        fsec = (elapsed_time) / 1000.00;
        rSec = Double.toString(fsec);
        rSec = rSec + " Sec";