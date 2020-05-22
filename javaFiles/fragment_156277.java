Scanner in = new Scanner("abc123");
for(;;) {
    String found = in.findWithinHorizon(".", 0);
    if(found == null) break;

    System.out.println(found);
}