public class Myjob{
    int id;
    int name;

    @ManyToOne
    @JoinColumn(name = "configuration_id", nullable = false)
    MyJobConfiguration configuration;
    //etc
}