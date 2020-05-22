System.out.println("Composer:");
    String composer = reader.readLine();

    System.out.println("Title");
    String title = reader.readLine();

    System.out.println("Duration");
    int duration = Integer.parseInt(reader.readLine());
    Song song = new Song(composer,title,duration);