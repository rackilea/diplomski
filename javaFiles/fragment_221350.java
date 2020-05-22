class Response {

    private String customerNumber;
    private String statusMessage;

    public Response(String id) {
        this.customerNumber = id;
        this.statusMessage = "Customer Created Successfully";
    }

    // getters, setters, etc
}