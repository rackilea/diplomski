// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.

String dateTimeStringZero = "2013-11-22T18:37:55.645+0000";
String dateTimeStringZulu = "2013-11-22T18:37:55.645Z";

org.joda.time.DateTime dateTimeZero = org.joda.time.format.ISODateTimeFormat.dateTime().withZoneUTC().parseDateTime( dateTimeStringZero );
org.joda.time.DateTime dateTimeZulu = org.joda.time.format.ISODateTimeFormat.dateTime().withZoneUTC().parseDateTime( dateTimeStringZulu );