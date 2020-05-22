class Response{

    private List<Result> apicall1;

    class Result{
        private String thisField;
        private String thatField;
        private String anotherField;
        public String getThisField() {
            return thisField;
        }
        public void setThisField(String thisField) {
            this.thisField = thisField;
        }
        public String getThatField() {
            return thatField;
        }
        public void setThatField(String thatField) {
            this.thatField = thatField;
        }
        public String getAnotherField() {
            return anotherField;
        }
        public void setAnotherField(String anotherField) {
            this.anotherField = anotherField;
        }
    }

    public List<Result> getApicall1() {
        return apicall1;
    }

    public void setApicall1(List<Result> apicall1) {
        this.apicall1 = apicall1;
    }
}