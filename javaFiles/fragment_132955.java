public class MyModel {

    private Long id; // use primitive type if, as I would think, id cannot be null

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}