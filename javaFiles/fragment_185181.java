@JacksonXmlRootElement
class MyRequest {


    private Collection<MySubRequest> mySubRequest;

    public Collection<MySubRequest> getRequests() {
        return mySubRequest;
    }

    @JacksonXmlProperty(localName = "MySubRequest")
    @JacksonXmlElementWrapper(useWrapping = false)
    public void setRequests(Collection<MySubRequest> requests) {
        this.mySubRequest = requests;
    }

}