public class Entity {

    @JsonDeserialize(contentAs = HomeImpl.class)
    private Collection<Home> homes = new ArrayList<>();

    public void setHomes(List<Home> homes) {
        if (homes != null)
            this.homes = homes;
    }
}