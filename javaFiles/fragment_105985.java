SQLQuery query =  session.createSQLQuery("SELECT * FROM MonthlySummary WHERE MentorID="+id );

query.addEntity(MonthlySummary.class);

reports = query.list();
--rest of code