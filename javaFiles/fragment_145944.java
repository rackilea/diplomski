Complaint complaint = new Complaint();
stockTran.setName("A complaint");
stockTran.setIssue("Hibernate SO question");
stockTran.setWhenAdded(new Date());

session.save(complaint);