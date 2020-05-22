findViewById(R.id.combatSwitchButtons).bringToFront();
    findViewById(R.id.pause).bringToFront();
    findViewById(R.id.spellButtons).bringToFront(); 
    findViewById(R.id.spellButtons).setVisibility(View.GONE);

    //this sets up what each button does.
    findViewById(R.id.pause).setOnClickListener(new OnClickListener()
    {
        public void onClick(View v)
        {               
            //TODO: Pause the game
        }
    });

    /*ALLL the on click listeners*/
    //This is for if we click spells on the switch interface. It'll make the spell buttons appear
    findViewById(R.id.spells).setOnClickListener(new OnClickListener()
    {
        public void onClick(View v)
        {   
            //change the mode
            game.spells=false;
            game.power=false;
            game.summons=true;

            //add the spells buttons and the drones
                findViewById(R.id.spellButtons).setVisibility(View.VISIBLE);    
    //TODO: remove other buttons
        }
    });