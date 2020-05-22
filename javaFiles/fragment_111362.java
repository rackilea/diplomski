while(!(play.equalsIgnoreCase("y")))
        {


            if(play.equalsIgnoreCase("n")){
                System.exit(1);
            }

            else{
                if((play.equalsIgnoreCase("y"))){
                    invalid();
                    guess=scan.nextInt();
 ....