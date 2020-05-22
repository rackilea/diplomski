// First we have to collect all "greatest" names.
// Always insert comma separator, which will leave us
// with (e.g.) ", a, b, c".  We'll fix it up later.
String names = "";
if (a == great) names += ", a";
if (b == great) names += ", b";
if (c == great) names += ", c";
  :

// If there are more than 2 greats we want to insert "and"
// thus ", a, b, c" => ", a, b, and c".  Note that another-dave
// is a fan of the oxford comma (so we do not want ", a, b and c").
if (names.length() > 6)  { // if more than 2 greats (3 chars each)
    names = names.substring(0, names.length()-1) + "and " +
            names.substring(names.length()-1);

// Finally, ditch the incorrect leading comma and space
names = names.substring(2);