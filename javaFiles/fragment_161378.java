public void testSplit() {
    String s = "Serial Data String TX, ID: 1, UOD: 1234, OK";

    String[] subs = s.split("\\s*,\\s*");

    String id = "not available";
    String uod = "not available";

    if(subs.length > 1) {
        String[] subsId = subs[1].split("\\s*:\\s*");
        if("ID".equals(subsId[0]) && subsId.length > 1) {
            id = subsId[1];
        }
    }

    if(subs.length > 2) {
        String[] subsUod = subs[2].split("\\s*:\\s*");
        if("UOD".equals(subsUod[0]) && subsUod.length > 1) {
            uod = subsUod[1];
        }
    }

    System.out.printf("ID=%s%nUOD=%s%n", id, uod);
}