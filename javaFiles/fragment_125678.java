Duration dur = DatatypeFactory.newDuration("P2DT15H45M0S");
int days = dur.getDays();
int hours = dur.getHours();
int minutes = dur.getMinutes();

String formatted = days + " Days " + hours + " Hrs " + minutes + " Min"