// Put departure & arrival into model class
data = new ReisData();
data.setDeparture(departureStation);
data.setArrival(arrivalStation);

// Start AsyncTask
GetInfo asyncTask = new GetInfo(this,data); // here is
asyncTask.execute(data);