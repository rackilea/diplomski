Context context = getActivity();
SharedPreferences sharedPref = context.getSharedPreferences("com.example.myapp.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE);
int defaultValue = 0;
long openedState = sharedPref.getInt("isAppOpenedBefore", defaultValue);

if (defaultValue == openedState)
{
   // First launch
   // Change volume
   // Writing app already opened state
   SharedPreferences.Editor editor = sharedPref.edit();
   editor.putInt("isAppOpenedBefore", 1);
   editor.commit();
}