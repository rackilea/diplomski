private List<String> queens;
    private String colour = "black";
    private int colonySize;


    public Ant() {
        queens = new ArrayList<>();
        queens.add("Beth");
        colonySize = 100000;
    }
    public void display() {
        System.out.println("Queen 1: " + this.queens.get(0));
        System.out.println("Colour of the ants: " + colour);
        System.out.println("The size of the colony: " + this.colonySize);
    }