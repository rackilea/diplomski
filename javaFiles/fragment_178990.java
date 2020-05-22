String str = "/name/exam/0oecda251d73jf82m33m92/run";
Pattern p = Pattern.compile("/.*/.*/(.*)/run");
Matcher m = p.matcher(str);
if (m.matches()) {
    System.out.println(m.group(1));
}