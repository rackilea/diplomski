class CustomerWrapper {
    @SerializedName("attributes")
    private Map<String, Customer> attributes;
}

class Customer {
    @SerializedName("options")
    private List<Produto> options;
}