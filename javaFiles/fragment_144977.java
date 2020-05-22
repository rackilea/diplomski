class PostCompany<T> {

    private final Poster<T> poster;

    public PostCompany(Poster<T> poster) {
        this.poster = poster;
    }

    public void send(T msg) { // <-- Here 
        this.poster.send(msg);
    }
}