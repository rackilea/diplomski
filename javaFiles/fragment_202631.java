int n=0;
    Scanner input = new Scanner(System.in);

    while (input.hasNext()) {
        try {
            n = Integer.parseInt(input.nextLine());
            //do something eg.- you have done
            //List.push(n);
        } catch (NumberFormatException nfe) { 
            //handle exception
        }
   }