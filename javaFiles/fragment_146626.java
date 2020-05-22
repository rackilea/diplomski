final Clubber clubberReference = doInTransaction(session -> {
    Clubber clubber = new Clubber();
    Club club = new Club();
    clubber.addClub(club);
    session.persist(club);
    return clubber;
});

doInTransaction(session -> {
    Clubber clubber = (Clubber) session.get(Clubber.class, clubberReference.getId());
    assertEquals(1, clubber.getClubs().size());
    assertEquals(1, clubber.getJoinDate().size());
});