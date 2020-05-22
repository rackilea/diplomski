//calculate start of next letter to highlight less the difference it took between time it took and time it should actually take
delay = (int) (timeToTake - dif);


//restart timer with new timings
//((Timer) ae.getSource()).setInitialDelay((int)timeToTake);//timer is usually faster thus the entire highlighting will be done too fast
((Timer) ae.getSource()).setInitialDelay(delay);
((Timer) ae.getSource()).restart();