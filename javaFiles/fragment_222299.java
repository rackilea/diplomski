(within onCreate)
...
SharedPreferences user_info = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
hole = user_info.getInt("hole", 0);
stroke = user_info.getInt("stroke", 0);
...
}

@Override
public void onPause()
    {
    super.onPause();
    SharedPreferences user_info = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    user_info.edit()
    user_info.putInt("hole", hole)
    user_info.putInt("strike", stroke)
    user_info.commit();
    }