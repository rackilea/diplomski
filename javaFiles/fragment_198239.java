dice1 = (ImageButton)findViewById(R.id.btndice1);  
    dice2 = (ImageButton)findViewById(R.id.btndice2); 
    dice3 = (ImageButton)findViewById(R.id.btndice3); 
    dice4 = (ImageButton)findViewById(R.id.btndice4); 
    dice5 = (ImageButton)findViewById(R.id.btndice5);

    ImageButton[] dice = new ImageButton[5]{dice1, dice2, dice3, dice4, dice5};

    for (int i = 0; i < dice.length; i++) {
         int id = R.drawable.ic_launcher;
         dice[i].setImageResource(id);
    }