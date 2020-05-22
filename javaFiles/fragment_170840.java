@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
public Category getCategory() {
    return category;
}

public void setCategory(Category category) {
    this.category = category;
}