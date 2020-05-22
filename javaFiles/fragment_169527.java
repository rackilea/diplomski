class DEV extends PROD {
    @Override
    int addUser(String name) {
        ... students work and test this one implementation
    }

    public static void main(String[] args) {
        ... do my testing thing here, like for instance
        System.out.println("This is the expected result using PROD:");
        PROD prod = new PROD();
        int result = prod.logon();  // internally calls PROD.logon() and PROD.addUser()
        System.out.println(result);

        System.out.println("This is the test result using DEV:");
        DEV dev = new DEV();
        result = dev.logon();  // internally calls PROD.logon() and DEV.addUser()
        System.out.println(result);
    }
}