@OneToOne(fetch = FetchType.LAZY)
 @PrimaryKeyJoinColumn
 private Product product;


public Product getProduct() {
    return product;
}