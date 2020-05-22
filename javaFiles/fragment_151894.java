navigationView = (NavigationView) findViewById(R.id.navigation_view); //Here you should enter your navigation view id
SwitchCompat piano = (SwitchCompat)
navigationView.getMenu().findItem(R.id.piano_switch); // But this depends on how you made your view in XML. It may be navigationView.getMenu().getItem(0).findItem(R.id.piano_switch);
piano.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.piano = isChecked;
                Log.d("Switch", "You a-toggled mah switch");
            }
        });