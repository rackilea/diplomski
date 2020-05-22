//Declare this globally. Not in oncreate.
int score = 0;
Random random = new Random();
int rbselector = random.nextInt(4);
int loadG4 = random.nextInt(10);


final Button[] selectrb = new Button[4];
selectrb[0] = rb1;
selectrb[1] = rb2;
selectrb[2] = rb3;
selectrb[3] = rb4;


final Button loseStarter4 = (Button) findViewById(R.id.Starter4);
loseStarter4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        infoG4.setVisibility(View.GONE);
        loseStarter4.setVisibility(View.GONE);
        rb1.setVisibility(View.VISIBLE);
        rb2.setVisibility(View.VISIBLE);
        rb3.setVisibility(View.VISIBLE);
        rb4.setVisibility(View.VISIBLE);


        rbselector = random.nextInt(4);

        final TextView number = (TextView) findViewById(R.id.number);
        number.setText(""+ loadG4);


        for(int allrbA=0; allrbA<4; allrbA++) {
            int rbvalue = random.nextInt(9);
            if (rbvalue == loadG4) {
                rbvalue+=1;
            }
            selectrb[allrbA].setText(""+rbvalue);
        }
        selectrb[rbselector].setText(""+ loadG4);


            for (int allrbA = 0; allrbA < 4; allrbA++) {
            selectrb[allrbA].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Button clicked = (Button) v;
                        String clickVal = (String) clicked.getText();
                        int finalClick = Integer.valueOf(clickVal);

                        if (finalClick == loadG4) {
                            score++;
                            loadG4 = random.nextInt(10); //removed declaration
                            for (int allrbA = 0; allrbA < 4; allrbA++) {
                                int rbvalue = random.nextInt(9);
                                if (rbvalue == loadG4) {
                                    rbvalue+=1; // better method to prevent duplicates for 9
                                }
                                selectrb[allrbA].setText("" + rbvalue);
                            }
                            number.setText("" + loadG4);
                            rbselector = random.nextInt(4);
                            selectrb[rbselector].setText("" + loadG4);
                        }
                }
            });
            }