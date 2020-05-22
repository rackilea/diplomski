Calendar c = Calendar.getInstance(); // current date
rDAO.load(makeRoosterId(c));         // Load this week
c.add(Calendar.WEEK_OF_YEAR, 1);
rDAO.load(makeRoosterId(c));         // Load next week
c.add(Calendar.WEEK_OF_YEAR, 1);
rDAO.load(makeRoosterId(c));         // Load the week after that