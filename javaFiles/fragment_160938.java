Calendar calendar = Calendar.getInstance();
calendar.setTime(date1);
calendar.set(Calendar.HOUR, 0);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);
calendar.set(Calendar.MILLISECOND, 0);

date1 = calendar.getTime();

calendar.setTime(date2);
calendar.set(Calendar.HOUR, 0);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);
calendar.set(Calendar.MILLISECOND, 0);

date2 = calendar.getTime();

TypedQuery<TestEntity> query = entityManager
.createQuery("select t from TestEntity t where greatest(nvl(t.f1, TO_TIMESTAMP('1970-01-01 00:00:00,000000001', 'YYYY-MM-DD HH24:MI:SS,FF9')), nvl(t.f2, TO_TIMESTAMP('1970-01-01 00:00:00,000000001', 'YYYY-MM-DD HH24:MI:SS,FF9')) between :date1 and :date2")
.setParameter("date1", date1)
.setParameter("date2", date2);