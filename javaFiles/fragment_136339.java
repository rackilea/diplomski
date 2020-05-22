@javax.persistence.Column(name = "productDescription")
    @Basic
    public String getProductDescription() {
            return productDescription;
        }

    public String getShortDescription() {
        return productDescription !=null ? productDescription.substring(0,20) : "";
    }