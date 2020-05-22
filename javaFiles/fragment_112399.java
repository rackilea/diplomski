SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
int previousitm =sharedPreferences.getInt("previousItemselected",0);


boolean flag =false;
        switch (pos){
            case 0:
                break;
        case 1:
            if(previousitm!=1)
                flag=true;
            editor.putInt("intervalInMinutes", 5*60*1000);
            editor.putInt("previousItemselected",1);
        break;
            case 2 :
            if(previousitm!=2)
                flag=true;
            editor.putInt("intervalInMinutes", 10*60*1000);
            editor.putInt("previousItemselected",2);
                break;
            case 3 :
            if(previousitm!=3)
                flag=true;
            editor.putInt("intervalInMinutes", 15*60*1000);
            editor.putInt("previousItemselected",3);
                break;
        }
        editor.apply();
        if(flag){
          GpsTrackerAlarmReceiver alarm = new GpsTrackerAlarmReceiver();
          alarm.setAlarm(getActivity());
        }
        }