SharedPreferences settings;
SharedPreferences.Editor SAVES;

Intent serviceIntent = new Intent(MainActivity.this, ServiceForCalls.class);
                    serviceIntent.setAction("xxx.xxx.NEXT_CALL");
                    startService(serviceIntent);
                    isCalling = true;

                    SAVES.putBoolean(   "isCalling" ,  isCalling  );
                    SAVES.commit();
                    SAVES.apply();