else if (mytime.equals("Every 5 Minutes")) {
fivemin=fivemin+1;

AlarmManager[] alarmManager=new AlarmManager[24];


ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();



Intent myIntent1 = new Intent(AndroidAlarmSMS.this,
                                    MyAlarmService.class);
                            Bundle bundle = new Bundle();
                    bundle.putInt("service", 1);
                    myIntent1.putExtras(bundle);


                            myIntent1.setData(Uri.parse("timer:myIntent1"));
                            pendingIntent = PendingIntent.getService(
                                    AndroidAlarmSMS.this, fivemin, myIntent1,0);

                            alarmManager[fivemin] =  (AlarmManager) getSystemService(ALARM_SERVICE);        
                            alarmManager[fivemin].setRepeating(AlarmManager.RTC_WAKEUP,
                                    calendar.getTimeInMillis(), 1000 * 60 * 2,
                                    pendingIntent);

                            intentArray.add(pendingIntent);