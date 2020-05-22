Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, -1);

// We would get the bounce mails received yesterday

ReceivedDateTerm term  = new ReceivedDateTerm(ComparisonTerm.EQ,new Date(cal.getTimeInMillis()));

Message[] messages = folder.search(term)