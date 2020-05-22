String matchedKey = "sessions.0.something.else";
Pattern newP = Pattern.compile("sessions\\.([^\\.]+)(\\..+)");
m = newP.matcher(matchedKey);
if (m.matches()) {
    System.out.println(m.group(1));
}