@Test
  void name3() {
    Product product = new Product(1);
    Product product1 = new Product(2);
    Product product2 = new Product(3);
    Product product3 = new Product(4);
    Product product4 = new Product(5);

    SkuDetail skuDetail1 = new SkuDetail(3);
    SkuDetail skuDetail2 = new SkuDetail(5);
    MyPackage myPackage =
        new MyPackage(Arrays.asList(product, product1, product2, product3, product4));

    List<Product> products =
        Stream.of(skuDetail1, skuDetail2)
            .map(
                sku ->
                    myPackage
                        .products
                        .stream()
                        .filter(p -> p.id == sku.sku)
                        .findFirst()
                        .map(
                            p -> {
                              return new Product(
                                  p.id); // create new product -> copy over all values
                            }))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());

    assertThat(products.size()).isEqualTo(2);
    assertThat(products).extracting("id").contains(3);
    assertThat(products).extracting("id").contains(5);
  }

  class MyPackage {
    List<Product> products;

    public MyPackage(List<Product> products) {
      this.products = products;
    }
  }

  class Product {
    int id;

    public Product(int id) {
      this.id = id;
    }
  }

  class SkuDetail {
    int sku;

    public SkuDetail(int sku) {
      this.sku = sku;
    }
  }