String zip1 = "A1A 1A1";
String zip2 = "A1A1A1";

String normalizedZip1 = normalizeZipCode(zip1);
String normalizedZip2 = normalizeZipCode(zip2);

System.out.println(isValid(normalizedZip1));
System.out.println(isValid(normalizedZip2));