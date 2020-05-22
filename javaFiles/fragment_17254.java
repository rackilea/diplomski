public static void main(String[] args) {
    if(args.length == 2) {
      processTickets(args[0], args[1]);
    } else {
      processTickets(getInputFileName(), getOutputFileName());
    }
  }