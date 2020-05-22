@Entity
@Table(name = "page")
class Page {
  ....

    @OneToMany
    @JoinTable(name = "jnd_pages_tags", joinColumns = @JoinColumn(name = "page_fk"),
            inverseJoinColumns = @JoinColumn(name = "tag_fk"))
    private Set<Tag> tags;      
}

@Entity
@Table(name = "page")
class Product {
  ....

    @OneToMany
    @JoinTable(name = "jnd_products_tags", joinColumns = @JoinColumn(name = "products_fk"),
            inverseJoinColumns = @JoinColumn(name = "tag_fk"))
    private Set<Tag> tags;      
}

@Entity
@Table(name = "tags")
class Tag {
.....
}