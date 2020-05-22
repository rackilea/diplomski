XmlDateTime xmlDateTime = XmlDateTime.Factory.newInstance();
xmlDateTime.setStringValue("2002-10-10T12:00:00-05:00");

System.out.println(xmlDateTime.xmlText());

GDateBuilder gdb = new GDateBuilder(xmlDateTime.getDateValue());
gdb.normalize();
xmlDateTime.setGDateValue(gdb.toGDate());

System.out.println(xmlDateTime.xmlText());