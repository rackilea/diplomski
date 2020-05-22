class Laboratory {

    private Computer[] computers;
    private int nextIndex = 0;

    public void addComputer(Computer comp) {
        // throws an ArrayOutOfBoundsException if the user
        // tries to add too many Computers. You might want to
        // do something else by checking that nextIndex < computers.length
        computers[nextIndex] = comp;
        nextIndex += 1;
    }

}