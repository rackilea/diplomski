public void update(Observable o, Object arg) {

   Subject = (Subject) o;
   int temperature = o.getTemperature();
   int dayInTime= o.getdayInTime();
   int season= o.getSeason();
}