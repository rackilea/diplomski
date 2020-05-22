// clone it before changing it
GregorianCalendar other = (GregorianCalendar) gc.clone();

gc.add(Calendar.DAY_OF_MONTH, -2);
System.out.println("Karfreitag;" + dateFormat.format(gc.getTime()));

other.add(Calendar.DAY_OF_MONTH, 1);
System.out.println("Ostermontag;" + dateFormat.format(other.getTime()));