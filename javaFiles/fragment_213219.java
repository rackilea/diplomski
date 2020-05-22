public static class Obj {

    private String mdl;
    private String ndc;
    private String gpi;
    private String labelName;
    private int seqNo;
    private String vendorName;

    // other getter/setters

    public String generateUniqueKey() {
        return mdl + ndc + gpi + seqNo;
    }
}