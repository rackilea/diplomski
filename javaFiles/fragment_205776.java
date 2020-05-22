String test = "Unbekannter Fehler: while trying to invoke the method test() of a null object loaded from local variable 'libInfo'";

Pattern pattern = Pattern.compile(".*" + Pattern.quote(test)  + ".*", Pattern.CASE_INSENSITIVE & Pattern.DOTALL);
Matcher matcher = pattern.matcher(test);

if (matcher.matches()) {
    System.out.println("Same!");
}