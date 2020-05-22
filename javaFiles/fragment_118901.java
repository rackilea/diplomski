TextView view = new TextView(this);
view .setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
    counter++;
    if(counter >= 10)
    {
        counter = 0;
        populateLayout();
    }
    }