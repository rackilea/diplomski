ToggleButton toggleButton1 = (ToggleButton) findViewById(R.id.togglebutton1);
toggleButton1.setChecked(true);

ToggleButton toggleButton2 = (ToggleButton) findViewById(R.id.togglebutton2);
toggleButton2.setChecked(true);

setToggleButtonColor(toggleButton1, ContextCompat.getColor(this, R.color.blue));
setToggleButtonColor(toggleButton2, ContextCompat.getColor(this, R.color.magenta));