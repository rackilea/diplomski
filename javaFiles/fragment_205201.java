FileReader freader = null;
Scanner    s       = null;
try { freader = new FileReader(args[0]); // risk null pointer exception here
      s = new Scanner(freader);
    }
catch { // etc.