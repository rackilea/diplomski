String Heading = parser.getValue(e, KEY_NAME);
int a=Heading.indexOf("|");
String beforeSubString=Heading.substring(0, a);
String afterSubString=Heading.substring(a, Heading.length()-1);
String final="<b>"+beforeSubString+"<b>"+"|"+afterSubString;
title.setText(Html.fromHtml(final));