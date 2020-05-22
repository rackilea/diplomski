OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        final ImageView imageView;
        if (adapterView.getId() == R.id.teamOneSpinner) 
            imageView = (ImageView) findViewById(R.id.team_one_spinner_team_logo);
        else
            imageView = (ImageView) findViewById(R.id.team_two_spinner_team_logo);

        String s=((TextView)view).getText().toString();
        if(s.equals("Arizona Cardinals"))
            imageView.setImageResource(R.drawable.arizona_cardinals);
        else if(s.equals("Atlanta Falcons"))
            imageView.setImageResource(R.drawable.atlanta_falcons));
        else if(s.equals("Baltimore Ravens")) 
            //etc, etc