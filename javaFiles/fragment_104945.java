int counter = 0;
  for(int i=0; i<any.length()-1; i++) {
        if(any.charAt(i) == '(') {
            counter++;
        } else if(any.charAt(i) == ')')) {
            counter--;
        }
        if (counter<0) {
          System.out.println("Close bracket with no open bracket found");
        }
    }

    if (counter > 0) {
        System.out.println("An open bracket was never closed");
    }