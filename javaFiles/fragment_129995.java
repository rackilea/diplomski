public class MyJobConfiguration {
    @OneToMany(mappedBy = "configuration")
    private List<MyJob> jobs;

    //bunch of configuration fields
}