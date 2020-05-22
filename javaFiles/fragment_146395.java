NavigationView  navigationView = findViewById(R.id.nav_view);


MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_isactive); // This is the menu item that contains your switch
Switch drawer_switch = (Switch) menuItem.getActionView().findViewById(R.id.m_swisactive);
drawer_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // Your logic goes here
        Toast.makeText(MainActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
    }
});