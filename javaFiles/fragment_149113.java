call.enqueue(new Callback<List<Pojo>>() {

   public void onResponse(List<Pojo> list) {
       for (Pojo pojo : list) {
           pojo.setDayOfWeek();
           pojo.setDate();
       }
   }

}