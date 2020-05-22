private Dimension clickLocation;

    public TestAction(String name, Dimension clickLocation) {
        super(name);
        this.clickLocation = clickLocation;
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Right click happened at " + clickLocation);
    }