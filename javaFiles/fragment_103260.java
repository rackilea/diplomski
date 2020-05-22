DAOManager dao = DAOManager.getInstance();
FirstDAO fDao = (FirstDAO)dao.getDAO(Table.FIRST);
SecondDAO sDao = (SecondDAO)dao.getDAO(Table.SECOND);
System.out.println(fDao.count());
System.out.println(sDao.count());
dao.close();