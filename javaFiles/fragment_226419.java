Query q = em.createQuery( 
    "SELECT t FROM Foo t WHERE ( EXTRACT(HOUR FROM t.std) * 60 + EXTRACT(MINUTE FROM t.std) ) >= :p_1" 
    );

Calendar cal = Calendar.getInstance();
cal.setTime(myDate);

int minutes = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
q.setParameter("p_1", minutes);