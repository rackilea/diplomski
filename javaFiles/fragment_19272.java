Pattern p1 = Pattern.compile("foo1");
Pattern p2 = Pattern.compile("foo2|foo3|foo4|foo5");  // match foo2 through foo5

if (p1.matcher(kvTarif.getkey()).matches() || p2.matcher(getkey()).matches()) {
    // handle this case
}