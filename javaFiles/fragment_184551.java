public String promComm( boolean answer ){
    if (answer){

        switch (randQuest.nextInt(1)){    
           case 0:
               return("Very Good!");
        }

        switch (randQuest.nextInt(1) ){
           case 0:                 
               return( "No. Please try again." );
        }

        return "Some value";

    }else

        return "Some value";
  }