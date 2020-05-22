@Column(name = "category_id", insertable=false, updatable=false)
@JsonProperty(value="categoryId")
private int categoryId;

@OneToOne
@JoinColumn(name = "category_id")
private Category category;

public int getCategoryId(){
    return category.getId();
}