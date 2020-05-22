public class Book
{
    public String status;
    // etc...
}

public String checkout(Book c) {
    c.status = "true";
    return c.status;
}