public ClassB {

    String some_property;

    public ClassB() {

        Properties p = new Properties();
        try {
            p.load( this.getClass().getResourceAsStream("your-props-file.properties") );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        some_property = p.getProperty("some_property");
    }

    public void foo() {
        System.out.println(some_property); 
    }
}