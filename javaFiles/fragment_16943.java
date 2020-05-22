public static int[][] sellSeatbyPrice(int[][] seats){
    Scanner kb=new Scanner(System.in);
    int ticketprice;
    int row = 0, col = 0;
    boolean found = false, seatavaliable=true;
    do{
      System.out.println("What is your prefered ticket price?");
      ticketprice=kb.nextInt();
      while (row<seats.length && !found){
        do{
          if(seats[row][col] == ticketprice){
            found = true;}
          else{
            col++; }  // this line, in the last iteration, will make col=seats[0].length
        }while(col<seats[0].length &&!found);
        if(seats[row][col] == ticketprice){ //col with value greater than it should.
          found = true;}
        else{
          row++;} 
      }
      if(found){
        seats[row][col] = 0; }
      else {
        System.out.println("Seat not found at specified price.");
        seatavaliable=false;}
    }while(seatavaliable==false);

    return seats;
  }