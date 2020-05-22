SimpleEmail email = new SimpleEmail();

MimeMultipart mmpa = new MimeMultipart("alternative");

//Calendar
MimeBodyPart calendarPart = new MimeBodyPart();
calendarPart.setHeader("Content-Type", "text/calendar; charset=UTF-8; method=REQUEST");
ByteArrayDataSource dsCalendario = new ByteArrayDataSource(str,"text/calendar;method=REQUEST");
DataHandler dhCalendario = new DataHandler(dsCalendario);
calendarPart.setDataHandler(dhCalendario);
mmpa.addBodyPart(calendarPart);

email.setContent(mmpa);