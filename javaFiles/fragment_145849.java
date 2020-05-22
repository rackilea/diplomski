class Phone{
    private Integer idPhone;
    private String name;
    private String model;
    private Long price;

    @OneToMany(mappedBY="phone")
    private List<Phone4Phone_Map> phone4Phone_Map;

    //Getters/Setters
}