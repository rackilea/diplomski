String theString = "a.b.c.d";

String separator = ".";
String replacement = "";
String newString = theString.substring(0, theString.lastIndexOf(separator)).replaceAll(separator , replacement).concat(theString.substring(theString.lastIndexOf(separator)));

Assert.assertEquals("abc.d", newString);