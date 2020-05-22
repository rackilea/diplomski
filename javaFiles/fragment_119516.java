public class Event {
    private List<PathListener> pls; //Or just one if you know you'll only need one
    //constructors, etc.

    public void pathFollowed(int location) {
        //this method could be called at any time
        for(PathListener pl : pls)
            pl.notifyLocation(location);
    }

    public addPathListener(PathListener pl) {
        pls.add(pl);
    }
}