serviceStopPoints request = new serviceStopPoints();
List<stopPoint> stopPointList = new ArrayList<stopPoint>();
stopPoint s = new stopPoint();
s.setArrivalAt("..");
.
.
.
stopPointList.add(s);
request.setTourID("1234);
request.setStopPoints(stopPointList);