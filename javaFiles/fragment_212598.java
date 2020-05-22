// INTERPOLATION
int i = 0;
Iterator<CircularFifoQueue<SensorEvent>> buf = samplingFifoQueues.iterator();
while (buf.hasNext()) {
    if ( i != 2 || mDeviceSensorGyro) {  // skip this queue if no gyroscope in device
       // proceed  
    }               

    buf.next();
    i++;
}