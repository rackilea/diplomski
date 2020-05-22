String unformatted = "00016282000079116050"; // <-- no need for String.valueOf
Pattern p = Pattern.compile("(\\d{5})(\\d{3})(\\d{2})(\\d{4})(\\d{3})(\\d{3})");
Matcher m = p.matcher(unformatted);
if (m.matches()) {
    System.out.printf("%s %s %s %s %s %s", m.group(1), m.group(2), m.group(3), 
            m.group(4), m.group(5), m.group(6));
}