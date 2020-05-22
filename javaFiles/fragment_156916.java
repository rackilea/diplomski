final Handler hand = new Handler();
    run = new Runnable() {

        @Override
        public void run() {
            if(count == 30) { //will end if count reach 30 which means 30 second
                goToGameOver(); 
            } 
            else
            {
                count += 1; //add 1 every second
                hand.postDelayed(run, 1000); //will call the runnable after 1 second

            }
        }
    };
    hand.postDelayed(run, 1000);