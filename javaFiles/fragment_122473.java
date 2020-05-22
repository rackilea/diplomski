String term = "PRM";
String special = "^-";

String delimiter = "[" + Pattern.quote(special) + "]*";
String regex = String.join(delimiter, term.split(""));

System.out.println(Pattern.matches(regex, "PROM"));      // --> false
System.out.println(Pattern.matches(regex, "P^^R---^M")); // --> true