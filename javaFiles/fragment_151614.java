public List<Product> getProductByCategory(String category) {

    List<Product> ret = new ArrayList<>();

    if(products.size() == 0){
        return ret;
    }

    for(Product p: this.products.values()) {
        if(p.getCategory().equals(category))
            ret.add(p);
    }

    return ret;
}