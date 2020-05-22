List<Walls> rooms = new ArrayList<Walls>();
rooms.add(new Walls(1,2,new Windows(1,2)));

//--- in Walls class:
Windows windows;

public Walls(int height, int width, Windows windows) {
    this.windows = windows;
    // the rest
}