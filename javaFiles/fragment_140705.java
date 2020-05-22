Scanner input = new Scanner (System.in);
LinkedList<Song> songList = new LinkedList<Song>();
ListIterator<Song> iter;
boolean done = false;

while (!done) {
   System.out.print ("Please enter a command (add, remove, print or quit): ");
   String command = input.nextLine();
   if (command.equals("QUIT")) {
     // If quit, then exit the loop.
     done = true;
   } else if (command.equals("ADD")) {
     addSong(songList, input);
     songCount++;
   } else if (command.equals("REMOVE")) {
     System.out.print ("Please enter song title: ");
     String removeTitle = input.nextLine();

     iter = songList.listIterator();
     while (iter.hasNext()) {
       String checkSongTitle = iter.next().getTitle();
       if (removeTitle.equals(checkSongTitle)) {
         iter.remove();
       }
     }
   } else if (command.equals("PRINT")) {
      .
      .
      .
   }
}