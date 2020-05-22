private void attachListenersOnColorButtons() {
    redButton = (Button) findViewById(R.id.buttonRed);
    redButton.setTag("RedButton"); // this tag will be used as identifier in onClick method
    redButton.setOnClickListener(this);

    blueButton = (Button) findViewById(R.id.buttonBlue);
    blueButton.setTag("BlueButton");
    blueButton.setOnClickListener(this);


    greenButton = (Button) findViewById(R.id.buttonGreen);
    greenButton.setTag("GreenButton");
    greenButton.setOnClickListener(this);
}

@Override
public void onClick(View v)
{
    if(v.getTag().equals("RedButton")){
        // actions when red button is pressed
    }else if(v.getTag().equals("BlueButton")){
        // corresponding actions for blue button
    }else if(v.getTag().equals("GreenButton"){
        // ...
    }
}