private void  persistData(ActivityDao<CAP#1-of-? extends BaseActivity> activityDao, Collection<CAP#2-of-? extends BaseActivity> data){
    EntityTransaction transaction = activityDao.getEntityManager().getTransaction();

    try {
        transaction.begin();

        activityDao.saveAll(data);
        transaction.commit();
    }
    catch (HibernateException ex) {
    }
}