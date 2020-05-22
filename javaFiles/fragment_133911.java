public void testPersistTeamAndPlayers() throws Exception {
    Team team = new Team("My Team");
    team.addPlayer(new Player());
    team.addPlayer(new Player());

    AnnotationConfiguration configuration = new AnnotationConfiguration();
    configuration.addAnnotatedClass(Team.class);
    configuration.addAnnotatedClass(Player.class);
    configuration.configure();

    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session;
    session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.save(team);
    transaction.commit();
    session.close();

    session = sessionFactory.openSession();
    @SuppressWarnings("unchecked") List<Team> list = session.createCriteria(Team.class).list();
    assertEquals(1, list.size());

    Team persisted = list.get(0);
    System.out.println(persisted);