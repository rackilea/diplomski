Pattern p = Pattern.compile(REGEX);
for(String formatStr : formatStrings) {
    Matcher m = p.matcher(formatStr);
    if(m.matches()) {
        System.out.println(m.group(1));
    }
    else {
        System.out.println("Didn't match!");
    }
}