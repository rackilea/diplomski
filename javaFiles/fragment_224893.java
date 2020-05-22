public static void printJobLog2(AS400 as400, Job job) {
    SpooledFile spooledFile = new SpooledFile(as400, "QPJOBLOG", 1, job.getName(), job.getUser(), job.getNumber());
    PrintParameterList printParms = new PrintParameterList();
    printParms.setParameter(PrintObject.ATTR_WORKSTATION_CUST_OBJECT, "/QSYS.LIB/QWPDEFAULT.WSCST");
    printParms.setParameter(PrintObject.ATTR_MFGTYPE, "*WSCST");
    try {
        InputStreamReader in = new
                InputStreamReader(spooledFile.getTransformedInputStream(printParms), "cp850");
        char[] buf = new char[32767];
        StringBuffer sbuf = new StringBuffer();
        if (in.ready()) {
            int bytesRead = 0;
            bytesRead = in.read(buf, 0, buf.length);
            while (bytesRead > 0) {
                sbuf.append(buf, 0, bytesRead);
                bytesRead = in.read(buf, 0, buf.length);
            }
        }
        System.out.println(sbuf.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}