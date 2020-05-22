public static Music buildObj() {
        Song song1 = new Song();
        Song song2 = new Song();
        Song song3 = new Song();

    Artist artist1 = new Artist();
    Artist artist2 = new Artist();

    song1.setGenre("ROCK       ");
    song1.setSonnet("X    ");
    song1.setNotes("Y    ");
    song1.setCompostions(Arrays.asList(new String[] { "SOME X DATA  ",
            "SOME OTHER DATA X ", "SOME MORE DATA X    ", " " }));

    Set<String> instruments = new HashSet<String>();
    instruments.add("         GUITAR    ");
    instruments.add("         SITAR    ");
    instruments.add("         DRUMS    ");
    instruments.add("         BASS    ");

    song1.setInstruments(instruments);

    song2.setGenre("METAL       ");
    song2.setSonnet("A    ");
    song2.setNotes("B    ");
    song2.setCompostions(Arrays.asList(new String[] { "SOME Y DATA  ",
            "          SOME OTHER DATA Y ",
            "           SOME MORE DATA Y    ", " " }));

    song3.setGenre("POP       ");
    song3.setSonnet("DONT    ");
    song3.setNotes("KNOW     ");
    song3.setCompostions(Arrays.asList(new String[] { "SOME Z DATA  ",
            "               SOME OTHER DATA Z ",
            "          SOME MORE DATA Z   ", " " }));

    artist1.setSongList(Arrays.asList(new Song[] { song1, song3 }));

    artist2.setSongList(Arrays.asList(new Song[] { song1, song2, song3 }));
    Map<String, Person> artistMap = new HashMap<String, Person>();
    Person tutor1 = new Person();
    tutor1.setName("JOHN JACKSON DOE       ");
    artistMap.put("          Name                 ", tutor1);

    Person coach1 = new Person();
    coach1.setName("CARTER   ");
    artistMap.put("Coach      ", coach1);
    artist2.setTutor(artistMap);

    music.setSongs(Arrays.asList(new Song[] { song1, song2, song3 }));
    music.setArtists(Arrays.asList(new Artist[] { artist1, artist2 }));

    music.setLanguages(new String[] { "    ENGLISH    ", "FRENCH    ",
            "HINDI    " });
    Person singer1 = new Person();
    singer1.setName("DAVID      ");

    Person singer2 = new Person();
    singer2.setName("JACOB      ");
    music.setSingers(new Person[] { singer1, singer2 });

    Human man = new Human();
    Person p = new Person();
    p.setName("   JACK'S RAGING BULL   ");
    SomeGuy m = new SomeGuy();
    m.setPerson(p);
    man.setMan(m);

    music.setHuman(man);

    return music;
}