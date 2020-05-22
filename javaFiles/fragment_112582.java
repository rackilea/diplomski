SharedPreferences.Editor editor = getSharedPreferences("com.mypck.asd", MODE_PRIVATE).edit();
if (RunService.isRunning) {
                RunService.stopRun(MainActivity.this);
                mFab.setDrawable(getResources().getDrawable(R.drawable.ic_play));                   
                editor.putBoolean("NameOfThingToSave", true);                    
            } else {
                startService(new Intent(MainActivity.this, RunService.class));
                mFab.setDrawable(getResources().getDrawable(R.drawable.ic_pause));
               editor.putBoolean("NameOfThingToSave", false);
            }
editor.commit();