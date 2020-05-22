Session session = sessionFactory.openSession();
try {
    session.beginTransaction();
    Barn b = (Barn) session.load(Barn.class, barn.getId());
    Horse h = (Horse) session.load(Horse.class, horse.getId());
    b.addHorse(h);
    session.update(b);
    session.update(h);
    session.getTransaction().commit();
} catch(Exception e) {
    session.getTransaction().rollback();
} finally {
    session.close();
}