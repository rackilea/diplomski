String s1 = "LATIN SMALL LETTER A WITH DIAERESIS";
int cp1 = Character.codePointOf(s1);
System.out.println("Unicode name \"" + Character.getName(cp1) + "\" => code point " + cp1 + " => character " + Character.toString(cp1));

String s2 = "EYES";
int cp2 = Character.codePointOf(s2);
System.out.println("Unicode name \"" + Character.getName(cp2) + "\" => code point " + cp2 + " => character " + Character.toString(cp2));

String s3 = "DNA Double Helix"; // Only works with JDK12 and later. Otherwise java.lang.IllegalArgumentException is thrown.
int cp3 = Character.codePointOf(s3);
System.out.println("Unicode name \"" + Character.getName(cp3) + "\" => code point " + cp3 + " => character " + Character.toString(cp3));