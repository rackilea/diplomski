List<?> users = //get data from either a query or criteria
criteria.add(Restrictions.and(Restrictions.in("userList", users),Restrictions.between("dateField", new SimpleDateFormat("dd-MM-YYYY").parse(fromDate), new SimpleDateFormat("dd-MM-YYYY").parse(toDate)));

OR

criteria.add(Restrictions.in("userList", users));
criteria.add(Restrictions.ge("systemDate", fromDt));
criteria.add(Restrictions.lt("systemDate", toDt));