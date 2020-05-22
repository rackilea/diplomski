// Count successes and print or check for botch 
        boolean isBotch=false;
        for(int s = 0; s < sux.size(); s++){
          if(sux.get(s) >= 7) {
            //s++; //no need to use this counter here again
            System.out.println((s+1) + " successes!"); // s+1 gives you right location
        } else {
            isBotch = true; //flag variable
        }
       }

        if(!isBotch){
            System.out.println("BOTCH!");
        }