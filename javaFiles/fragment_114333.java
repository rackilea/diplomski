ArrayList<Integer> q = new ArrayList<Integer>();
    Random r = new Random();
    int arrivals = 0;

    for (int i = 1; i < 100 ; i++) { //loop as many times as you want.
        int time = r.nextInt(4)+1; //choose a random time of arrival, 1-4

        //now compare time to your random time intervals (1-4, not i
        //if it matches add that value to i
        if (time == 1) {  
            //add your object to the list
            i += 1; 
        }
        else if (time == 2) {
            //add your object to the list
            i += 2;
        }

        else if (time == 3) {
            //add your object to the list
            i += 3;
        }
        else if (time == 4) {
            //add your object to the list
            i += 4;
        }
    }