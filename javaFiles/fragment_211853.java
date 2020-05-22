class Post {
    private String body;

    public String getBody() {
        return body;
    }
}

class MyPost extends Post {
    private String body;

    public void setBody(String body) {
        this.body = body;
    }

    @Override    
    public String getBody() {
        return body;
    }
}