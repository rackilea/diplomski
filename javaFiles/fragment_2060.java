Long count = hibernateTemplate.execute(new HibernateCallback<Long>() {
    @Override
    public Long doInHibernate(Session session) {
        return (Long) session.createQuery("select count(someEntity.id) from SomeEntiuty someEntity ...").uniqueResult();
    }
});