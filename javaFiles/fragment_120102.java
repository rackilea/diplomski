change the forloop with below one....

for(int i=0;i<winningLocation.length;i++){
        Boolean istie = true;
        int []winningPostion = winningLocation[i];
        mesg="there is no winner ";

        if(gameState[winningPostion[0]] == gameState [winningPostion[1]]
                && gameState[winningPostion[1]]== gameState [winningPostion[2]]
                && gameState[winningPostion[0]]!=2){
            mesg="there is no winner ";
            if (activePlayer ==0)
                mesg = "O is the winner!";

            if(activePlayer==1)
                mesg = "X is the winner!";

            LinearLayout winnerLayout =(LinearLayout)findViewById (R.id.winnerLayout);
            winnerLayout.setVisibility(View .VISIBLE);

            TextView winnermesg = (TextView) findViewById(R.id.editText);
            winnermesg.setText(mesg);
            istie = false;
            gameover=true;
             return;
        }
        if(i==winningLocation.length-1){
            if(istie){
                LinearLayout winnerLayout =(LinearLayout)findViewById (R.id.winnerLayout);
                winnerLayout.setVisibility(View .VISIBLE);

                TextView winnermesg = (TextView) findViewById(R.id.editText);
                winnermesg.setText(mesg);
            }

        }
    }