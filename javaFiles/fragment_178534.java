LinearLayout linearChildren = (LinearLayout) findViewById(R.id.linEvents);        
    Resources res = getResources();
    for (int count = 0; count < numberOfEvents; count++) {
        Drawable checkbox = res.getDrawable(R.drawable.custom_checkbox_design);
        CheckBox event = new CheckBox(ActivityAttend.this);
        event.setText(todaysEvents.get(count).getEventName());            
        event.setButtonDrawable(checkbox);
        linearChildren.addView(event);
    }