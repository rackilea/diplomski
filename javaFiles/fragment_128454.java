class Human {
    private int Age = 0;
    private int Weight = 0;
    private int Height = 0;
    private String name = "";
    private boolean isMale;

    public int getAge() {
        return Age;
    }

    public int getWeight() {
        return Weight;
    }

    public int getHeight() {
        return Height;
    }

    public Human(int Age, int Weight, int Height, String name, boolean isMale) {
        this.Age = Age;
        this.Weight = Weight;
        this.Height = Height;
        this.name = name;
        this.isMale = isMale;

        //returns nothing
    }
}