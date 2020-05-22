//delete this code
 @Override
    public void onClick(View v)
    {
        v.setVisibility(View.INVISIBLE);
        counter++;
        if(counter >= 10)
        {
            counter = 0;
            populateLayout();
        }
    }