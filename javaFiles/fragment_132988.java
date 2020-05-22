public class UserModel {

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "book_user_table", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<BookModel> books;

    //Getters and setters
}