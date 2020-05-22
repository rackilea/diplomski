String exampleValue = "@ CDSFSF";
Pattern pattern = Pattern.compile("^@\\s+");
long start = System.currentTimeMillis();
for (int i = 0; i < 100000 ; i++) {
    pattern.matcher(exampleValue).replaceFirst("");
}
long end = System.currentTimeMillis();
System.out.println(end - start);