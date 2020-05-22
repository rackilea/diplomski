int slash1 = birthday.indexOf('/', 0);
int slash2 = birthday.indexOf('/', slash1 + 1);

String inputMonth = birthday.substring(0, slash1);
String inputDay = birthday.substring(slash1 + 1, slash2);
String inputYear = birthday.substring(slash2 + 1, birthday.length());