String exampleValue = "@ CDSFSF";

long start = System.currentTimeMillis();
for (int i = 0; i < 100000 ; i++) {
    exampleValue.replaceFirst("^@\\s+", "");
}
long end = System.currentTimeMillis();
System.out.println(end - start);