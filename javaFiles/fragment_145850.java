class Phone4Phone_Map{

    private Integer idPhone_in
    private Integer idPhone_out
    private Date valid_since
    private String reason

    @ManyToOne
    @JoinColumn(name="idPhone_out")
    private Phone phone;

    //Getters/Setters
}