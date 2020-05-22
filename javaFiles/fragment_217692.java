Scanner scan = new Scanner(System.in);
    System.out.println("Enter the names of each song in the DJ's playlist: ");
    System.out.println("When finished, enter done.");
    ArrayList <String> NamesOfSongs = new ArrayList<>();
    boolean loop = true;

    while(loop) {
        String input = scan.nextLine();
        if(input.equals("done")) {
            /* Stop the input => stop while loop*/
            loop = false; 
        } else {
            /* add song */
            NamesOfSongs.add(input);
        }
    }

    /* Print the song*/
    for(int i = 0; i < NamesOfSongs.size(); i++) {
        System.out.println(NamesOfSongs.get(i));
    }
}