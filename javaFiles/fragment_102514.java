Query query = sessionfactory.getCurrentSession().createSQLQuery(
    "SELECT count(Distinct(DATEPART(wk,spentDate))) " + 
    "FROM TblTimesheet where timesheetStatus = ? " + 
    "and tblUserDetailsByApprover = ?");
query.setParameter(0,"Pending");
query.setParameter(1, user);
logger.info("size"+query.getSingleResult());