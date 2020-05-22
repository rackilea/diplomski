listOfAlarms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Singleton .getInstance().setAllarms(alarms); // Save the Collection

               alarms.get(position);

                Intent clockDownActivity = new Intent(ListOfAlarms.this, CountDownAct.class);
               clockDownActivity.putExtra("Title", title);
               clockDownActivity.putExtra("totalTime", totalTime);
                startActivity(clockDownActivity);
           }
        });