View.OnClickListener imgButton0Handler0 = new View.OnClickListener() {
        int identifier=0;

        public void onClick(View v) {

            //check if tile is found and return if it is
            if(isFound[identifier]==true)   return;
            //set tile as open
            checkField[identifier]=1;

            //set background on predetermined
            button0.setBackgroundResource(tiles[identifier]);

             new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        checker(identifier)  // your method call
                    }
                }, 3000); // 3 second
            }
    };