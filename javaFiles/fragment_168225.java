/**
     * Constructor for objects of class Shuttle
     * @param id This shuttle's unique id.
     * @param route The route taken by this shuttle.
     *              The first entry is the starting location.
     */
    public Shuttle(String id, ArrayList<String> route)
    {
        super(id,route.get(0));
        setRoute(route);
    }