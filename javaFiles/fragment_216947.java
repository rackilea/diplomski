class Crew {

    private final ArrayList<Sailor> sailors = new ArrayList<>();

    //other things, like constuctor here, if needed 

    public void addCrewMember(Sailor s) { //add sailors with this
        sailors.add(s);
    }
}