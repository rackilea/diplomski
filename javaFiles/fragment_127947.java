shellinput[0] = "/system/xbin/dd if=/dev/zero of=";
shellinput[1] = newvfspath;
shellinput[2] = "/gtj.img bs=1000000 count=";
shellinput[3] = gtjsize;
System.out
        .println("Error Code (making new "
                + newvfspath
                + "/gtj.img ) :
            + errorstreamReader(shellinput)"
private String errorstreamReader(String[] shellinput) {
    InputStream inputstream = null;
    String esrval = null;
    System.out.println("Entering errorstreamReader");
    //hack to prevent executing null
    for (int i = 0; i <= 3; i++) {
        if (shellinput[i] == null) {
            shellinput[i] = "";
        }
    }
    try {
    System.out.println("Executing " + shellinput[0]
                + shellinput[1] + shellinput[2] + shellinput[3]);
        inputstream = Runtime
                .getRuntime()
                .exec(shellinput[0]
                + shellinput[1] + shellinput[2] + shellinput[3]).getErrorStream();// this fixed it, typo
    } catch (IOException e) {
        e.printStackTrace();
    }
    InputStreamReader inputstreamreader = null;
    try {
        inputstreamreader = new InputStreamReader(inputstream);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        esrval = new BufferedReader(inputstreamreader).readLine();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
    return esrval;
}