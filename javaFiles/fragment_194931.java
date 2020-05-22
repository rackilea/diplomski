@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RESULT && resultCode == RESULT_OK){


               title = data.getStringExtra("title");
                totalTime = data.getIntExtra("totalTime", 0);


               Singleton.getInstance().getAllarms().add(new TestAlarm(title, totalTime));

               this.alarms  = Singleton.getInstance().getAllarms();
               alarmArrayAdapter.notifyDataSetChanged();

        }
    }