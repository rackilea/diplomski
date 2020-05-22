Calendar from = Calendar.getInstance();
Calendar to = Calendar.getInstance();

from.add(Calendar.DATE, -1);
to.add(Calendar.DATE, 1);

Query q = em.createQuery("SELECT r FROM Reserve r WHERE r.date > :dateFrom AND r.date < :dateTo ");
q.setParameter("dateFrom", from.getTimeInMillis());
q.setParameter("dateTo", to.getTimeInMillis());