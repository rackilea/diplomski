// X - return false if number is less than 1190
String X = "119[0-9]|1[2-9][0-9]{2}|[2-9][0-9]{3}"; 

// Y - return false if number is greater than 1992.
String Y = "1[0-8][0-9]{2}|19[0-8][0-9]|199[0-2]";

String pattern = "(?=" + X + ")" + Y;

String values = "1000 1100 1180 1189 1190 1191 1199 1200 1290 1900 1980 1989 " +
                "1990 1991 1992 1993 1999 2000 3000 2991 9999";
for (String string : values.split(" ")) {
    System.out.printf("\"%s\" %s%n", string, string.matches(pattern));
}