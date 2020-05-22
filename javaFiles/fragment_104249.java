String songName = "Maad City, Kendrick Lamar, Hip-Hop";
    String fileName = "songs.txt";

    SongTextFileProcessor stfp = new SongTextFileProcessor ();

    stfp.writeSong(songName, fileName);
    stfp.readSong(fileName);