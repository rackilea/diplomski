if (diffDays <= 0) {
    final SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    final boolean notification01 = sharedPreferences.getBoolean("notification01", false);

    if (!notification01) {
        String diffDaysAvailable = "ready";
        ((TextView) android.findViewById(R.id.readyLeft)).setText(diffDaysAvailable);
        activity.sendNotificationIfTimeEnd01();
        Log.d("MyApp", "notification 1");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("notification01", true);
        editor.apply();
    }
}