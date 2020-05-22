String line = input.nextLine (); 
    Scanner valueLine = new Scanner (line);
    List<Integer> books = new LinkedList<>();

    while (valueLine.hasNextInt ()) {            
        books.add (valueLine.nextInt ());
    }