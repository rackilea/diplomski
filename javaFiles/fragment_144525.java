entry = new SyndEntryImpl();
entry.setTitle("ROME v3.0");
entry.setLink("http://wiki.java.net/bin/view/Javawsxml/Rome03");
entry.setPublishedDate(DATE_PARSER.parse("2004-07-27"));
description = new SyndContentImpl();
description.setType("text/html");
description.setValue("<p>More Bug fixes, mor API changes, some new features and some Unit testing</p>"+
                     "<p>For details check the <a href=\"http://wiki.java.net/bin/view/Javawsxml/RomeChangesLog#RomeV03\">Changes Log</a></p>");
entry.setDescription(description);
entries.add(entry);