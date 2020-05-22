Pattern pattern = Pattern.compile("^Index:.*\\/(.*)", Pattern.MULTILINE);

Matcher matcher = pattern.matcher(line);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}

// Output: 
atsAPI.tcl
atsAPI1.tcl