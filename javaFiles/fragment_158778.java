TempSensor ts = new TempSensor();
TStream<Double> temp = top.poll(ts, 1, TimeUnit.MILLISECONDS).filter(tuple ->
tuple < OPTIMAL_TEMP_LOW || tuple > OPTIMAL_TEMP_HIGH);
temp.sink(tuple -> System.out.println("Temperature is out of range! "
+ "It is " + tuple + "\u00b0F!"));

// See what the temperatures look like
temp.print();

dp.submit(top);