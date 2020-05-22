if (args.length == 1) {
     if (args[0].trim().equalsIgnoreCase("mobile") ) {
        updateDB = true;
     }
  else {
        System.out.println(" 1 :Usage: ./run.sh [mobile] "+ args[0]);
        return;
     }
  }