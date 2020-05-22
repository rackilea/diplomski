XmlDateTime xmlDateTime = XmlDateTime.Factory.newInstance();
Calendar xmlCalendar = new XmlCalendar();
xmlCalendar.set(Calendar.YEAR, 2014);
xmlCalendar.set(Calendar.MONTH, 2);
xmlCalendar.set(Calendar.DATE, 22);
xmlDateTime.setCalendarValue(xmlCalendar);