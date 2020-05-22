do{
  do{//New coversion?
    System.out.println();
    System.out.println("Would you like to make another conversion ? (Y/N)");

    response = sc.next().charAt(0);
  } while (response != 'Y' & response != 'N'); // Filtering other awnsers than Y or N.

} whil