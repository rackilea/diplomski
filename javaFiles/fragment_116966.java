public class Stylist extends Model {

    @ManyToMany
    @JoinTable(name = "salon_stylist", ...)
    public List<Salon> salons;

    ...
}