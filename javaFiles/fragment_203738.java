long start = System.nanoTime();
for(int i=0; i< 1000000; i++) {
    String name = "This String is Foo Bar";
    name = StringUtils.replaceEach(name, matches, replaces);
}
System.out.println((System.nanoTime() - start)/1000000);