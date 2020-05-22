public class Salon extends Model {

    @ManyToMany
    @JoinTable(name = "salon_stylist", ...)
    public List<Stylist> stylists;

    ...
}