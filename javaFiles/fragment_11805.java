@JoinColumns({
    @JoinColumn(name="VERSION", referencedColumnName="VERSION"),
    @JoinColumn(name="PARENT_ID", referencedColumnName="CATAGORY_ID")
})
@ManyToOne
private Catagory parentId;

@OneToMany(mappedBy="parentId")
private List<Catagory> childs;