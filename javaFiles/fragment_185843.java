class OtherClass {
    public static void main(String[] args) {
        String LOCAL_POOK = DatacenterEnum.getOurlocation().toLocalPook(
                Flow.USERFLOW);
        System.out.println(LOCAL_POOK);
    }

}