int counter = 0;
  for(int i=0; i<sArray.length-1; i++){
        if(sArray[i].equals("(")){
            counter++;
        }
        if(sArray[i].equals(")")){
            counter--;
        }
        if (counter<0) {
          System.out.println("Close bracket with no open bracket found");
        }
    }

    if (counter > 0) {
        System.out.println("An open bracket was never closed");
    }