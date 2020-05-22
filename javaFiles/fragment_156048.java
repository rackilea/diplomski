Employee e1 = new Employee();
  Company c1 = new Company();
  c1.employees.add(e1);

  e1.companies.add(c1);

  ScheduleOwner so = new ScheduleOwner();
  so.c = c1;
  so.e = e1;

  Schedule s = new Schedule();
  s.owner = so;

  session.save(c1);
  session.save(e1);
  session.save(s);

  // below query will fetch from schedule, where company id = 9
  Schedule ss = (Schedule) session.createQuery("From Schedule sh where sh.owner.c.id = 9").uniqueResult();