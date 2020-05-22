SharedPreferences sharedPref = getSharedPreferences("My_Prefs", Context.MODE_PRIVATE);

        final Spinner spinnerBackgroundChange = (Spinner)findViewById(R.id.spinner1);

        int lastSelectedPosition = sharedPref.getInt("spinnerValue", 0);
        spinnerBackgroundChange.setSelection(lastSelectedPosition);